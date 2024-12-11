import android.content.Context
import com.example.wooperland_enserio.service.AuthApiService
import com.example.wooperland_enserio.service.ChildrenApiService
import com.example.wooperland_enserio.service.TopicService
import com.example.wooperland_enserio.utils.MyApp
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {

    private val retrofit: Retrofit

    init {
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()

        // Interceptor para logging de la solicitud/respuesta
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        // Configuración del cliente OkHttp con interceptores
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor) // Interceptor para ver las solicitudes
            .addInterceptor { chain ->
                val token = getAuthToken() // Obtén el token del SharedPreferences
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $token") // Agrega el token a la cabecera
                    .build()
                chain.proceed(request)
            }
            .writeTimeout(2, TimeUnit.MINUTES) // Timeout de escritura
            .connectTimeout(1, TimeUnit.MINUTES) // Timeout de conexión
            .build()

        // Construcción de Retrofit
        retrofit = Retrofit.Builder()
            .baseUrl("https://backend-production-40d8.up.railway.app/v1/") // URL base
            .addConverterFactory(GsonConverterFactory.create(gson)) // Convertidor JSON
            .addCallAdapterFactory(CoroutineCallAdapterFactory()) // Adaptador de corutinas
            .client(okHttpClient) // Cliente OkHttp con interceptores
            .build()
    }

    // Recupera el token de los SharedPreferences
    private fun getAuthToken(): String? {
        val context = MyApp.context // Asegúrate de que MyApp.context esté correctamente configurado
        val sharedPreferences = context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
        return sharedPreferences.getString("jwt_token", null) // Obtén el JWT del SharedPreferences
    }

    fun saveAuthToken(token: String) {
        val context = MyApp.context // Asegúrate de que MyApp.context esté configurado correctamente
        val sharedPreferences = context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("jwt_token", token).apply() // Almacena el accessToken
    }


    // Métodos para obtener los servicios de la API
    fun getAuthService(): AuthApiService = retrofit.create(AuthApiService::class.java)
    fun getChildrenService(): ChildrenApiService = retrofit.create(ChildrenApiService::class.java)
    fun getTopicService(): TopicService = retrofit.create(TopicService::class.java)
    fun getProfileChildService(): ChildrenApiService = retrofit.create(ChildrenApiService::class.java)

}
