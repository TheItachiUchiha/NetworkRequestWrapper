package com.ankit.volleywrapper;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

/**
 * Created by suyash.bhagwat on 5/25/2015.
 */
public class ErrorCode {

    public final static int NULL_POINTER_EXCEPTION = 100;

    public final static int INVALID_JSON =101;

    /**
     * Error code when response is null.
     */
    public static final int RESPONSE_NULL = 20;

    /**
     * Error code when volley error is not predicted.
     */
    public static final int VOLLEY_UNKNOWN_ERROR = 110;

    /**
     * Error code when volley returns network error.
     */
    public static final int VOLLEY_NETWORK_ERROR = 111;

    /**
     * Error code when volley returns no connection error.
     */
    public static final int VOLLEY_NO_CONNECTION_ERROR = 112;

    /**
     * Error code when volley returns client error.
     */
    public static final int VOLLEY_CLIENT_ERROR = 113;

    /**
     * Error code when volley returns server error.
     */
    public static final int VOLLEY_SERVER_ERROR = 114;

    /**
     * Error code when volley returns auth failure error.
     */
    public static final int VOLLEY_AUTH_FAILURE_ERROR = 115;

    /**
     * Error code when volley returns parse error.
     */
    public static final int VOLLEY_PARSE_ERROR = 116;

    /**
     * Error code when volley returns request timeout error.
     */
    public static final int VOLLEY_TIMEOUT_ERROR = 117;
    

	
	
	/**
     * Error code when exception is catched and need to report to GA.
     */
    public static final int CATCH_EXCEPTION = 1001;

	public static final int JSON_EXCEPTION = 1002;
	
	public static final int POST_PARAMS_IS_NULL = 1003;
	
	public static final int RESPONSE_TAG_IS_NULL = 1004;
	/**
	 * Error Code when invalid or insufficient request parameters
	 * */
	public static final int INSUFFICIENT_REQUEST_PARAM = 1005;
	
	
	public static final int SHOW_TOAST_ON_FAILURE = 1006;
	
	public static final int SHOW_DIALOG_ON_FAILURE = 1007;
	
	public static final int URL_INVALID = 1008;

    public static final int DATA_NOT_FOUND = 1009;

    /**
     * @param volleyError
     *            - error encountered while executing request with
     *            {@link Volley}
     * @return Returns {@link ErrorCode} according to type of
     *         {@link VolleyError}
     */
    public static int getErrorCode(VolleyError volleyError) {

        int errorCode = 0;

        if (volleyError != null) {

            if (volleyError instanceof NetworkError) {
                errorCode = ErrorCode.VOLLEY_NETWORK_ERROR;
            } else if (volleyError instanceof NoConnectionError) {
                errorCode = ErrorCode.VOLLEY_NO_CONNECTION_ERROR;
            } /*else if (volleyError instanceof ClientError) {
				errorCode = ErrorCode.VOLLEY_CLIENT_ERROR;
			} */else if (volleyError instanceof ServerError) {
                errorCode = ErrorCode.VOLLEY_SERVER_ERROR;
            } else if (volleyError instanceof AuthFailureError) {
                errorCode = ErrorCode.VOLLEY_AUTH_FAILURE_ERROR;
            } else if (volleyError instanceof TimeoutError) {
                errorCode = ErrorCode.VOLLEY_TIMEOUT_ERROR;
            } else if (volleyError instanceof ParseError) {
                errorCode = ErrorCode.VOLLEY_PARSE_ERROR;
            } else {
                errorCode = ErrorCode.VOLLEY_UNKNOWN_ERROR;
            }
        }

        //LibraryLog.e(TAG, "ErrorCode: " + errorCode + "\n Message:" + volleyError.getMessage());

        return errorCode;
    }
}
