package com.easyhome.utils;

public interface ReturnCode {

	/** [GET]：服务器成功返回用户请求的数据， */
	int STATUS_200 = 200;
	/** [POST/PUT/PATCH]：用户新建或修改数据成功。 */
	int STATUS_201 = 201;
	/** 表示一个请求已经进入后台排队（异步任务） */
	int STATUS_202 = 202;
	/** [DELETE]：用户删除数据成功。 */
	int STATUS_204 = 204;
	/** [POST/PUT/PATCH]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的 */
	int STATUS_400 = 400;
	/** 表示用户没有权限（令牌、用户名、密码错误）。 */
	int STATUS_401 = 401;
	/** 表示用户得到授权（与401错误相对），但是访问是被禁止的。 */
	int STATUS_403 = 403;
	/** 用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的 */
	int STATUS_404 = 404;
	/** [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式） */
	int STATUS_406 = 406;
	/** [GET]：用户请求的资源被永久删除，且不会再得到的。 */
	int STATUS_410 = 410;
	/** [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。 */
	int STATUS_422 = 422;
	/**用户没有输入页码 */
	int STATUS_423 = 423;
	/**用户没有输入每页要查多少条？ */
	int STATUS_424 = 424;
	/** 没有绑定到masterid */
	int STATUS_425 = 425;
	/** 上面代码有问题 */
	int STATUS_426 = 426;
	/** 服务器发生错误，用户将无法判断发出的请求是否成功。 */
	int STATUS_500 = 500;
	
	// 与微信接口返回标识 0：返回结果成功 1：返回结果失败
    int WECHAT_RESULT_FAILURE = 1;// 1：返回结果失败
    int WECHAT_RESULT_SUCCESS = 0;// 0：返回结果成功

	String OK = "OK";
	String ERROR = "ERROR";
	String FAIL = "SERVER ERROR";
	String NO_DATA = "NO DATA";
	String NO_MASTERID = "NO MASTERID";
}
