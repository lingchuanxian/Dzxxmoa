package cn.com.kind.dzxxmoa.api;

import cn.com.kind.dzxxmoa.bean.HttpResult;
import cn.com.kind.dzxxmoa.bean.User;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * 请求接口
 * @author ling_cx
 * @date 2017/5/4.
 */

public interface ApiService {

	@GET("WebService/Main.asmx/Login")
	Observable<HttpResult<User>> userLogin(@Query("signon") String signon,
										   @Query("password") String password,
										   @Query("soapJson") boolean soapJson,
										   @Query("ifKeyLogin") boolean ifKeyLogin);

	@GET("WebService/Main.asmx/Operate")
	Observable<String> operate(@Query("ticket") String ticket,
								 @Query("operateType") String operateType,
								 @Query("paraType") String paraType,
								 @Query("paraInfo") String paraInfo,
								 @Query("soapJson") boolean soapJson);

	@GET("App/GetNewAppManage.asmx/GetNewAppDetail")
	Observable<String> getNewAppDetail(@Query("appCode") String appCode,
														@Query("appType") String appType,
														@Query("appDisplay") String appDisplay);

	@GET("WebService/GetKeyRand.asmx/CheckKeyResult")
	Observable<String> CheckKeyResult(@Query("appCode") String appCode,
									  @Query("strSrc") String strSrc,
									  @Query("strB64Sign") String strB64Sign,
									  @Query("strB64Cert") String strB64Cert);

	@Streaming
	@GET
	Observable<ResponseBody> downloadFile(@Url String url);

}
