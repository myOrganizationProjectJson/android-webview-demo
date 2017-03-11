package com.example.pw;

import com.example.pw.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	private static final String APP_CACAHE_DIRNAME = null;
	private WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		   //无title 
//	       requestWindowFeature(Window.FEATURE_NO_TITLE); 
//	        //全屏 
//	       getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,    
//	                      WindowManager.LayoutParams. FLAG_FULLSCREEN); 
	       
	       setContentView(R.layout.activity_main);
		init();
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
	
	 @Override  
	 public boolean onKeyDown(int keyCode, KeyEvent event) {  
	        if(keyCode == KeyEvent.KEYCODE_BACK&&webView.canGoBack()){  
	            webView.goBack();//返回上个页面  
	            return true;  
	        }  
	        return super.onKeyDown(keyCode, event);//退出整个应用程序  
	 }  
	 
	   @SuppressLint("SetJavaScriptEnabled")
	private void init(){
	        webView = (WebView) findViewById(R.id.webView);
	      //启用支持javascript
	        webView.getSettings().setJavaScriptEnabled(true);  
	        webView.getSettings().setRenderPriority(RenderPriority.HIGH);  
	        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);  //设置 缓存模式  
            // 开启 DOM storage API 功能  
	        webView.getSettings().setDomStorageEnabled(true);  
            //开启 database storage API 功能  
	        webView.getSettings().setDatabaseEnabled(true);   
            String cacheDirPath ="file:///android_asset/";//getFilesDir().getAbsolutePath()+APP_CACAHE_DIRNAME;  
    //      String cacheDirPath = getCacheDir().getAbsolutePath()+Constant.APP_DB_DIRNAME;  
            //设置数据库缓存路径  
            webView.getSettings().setDatabasePath(cacheDirPath);  
            //设置  Application Caches 缓存目录  
            webView.getSettings().setAppCachePath(cacheDirPath);  
            //开启 Application Caches 功能  
            webView.getSettings().setAppCacheEnabled(true);  
	        //WebView加载web资源
	       //webView.loadUrl("https://www.baidu.com/");
	       webView.loadUrl("file:///android_asset/example.html");
	        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
	       WebSettings settings = webView.getSettings();
	       settings.setJavaScriptEnabled(true);
	       //全屏？
	      // settings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
	       settings.setUseWideViewPort(true); 
	       settings.setLoadWithOverviewMode(true); 
//	       
//	       DisplayMetrics metrics = new DisplayMetrics();
//	       getWindowManager().getDefaultDisplay().getMetrics(metrics);
//	       int mDensity = metrics.densityDpi;
//	       if (mDensity == 120) {
//	       settings.setDefaultZoom(ZoomDensity.CLOSE);
//	       }else if (mDensity == 160) {
//	       settings.setDefaultZoom(ZoomDensity.MEDIUM);
//	       }else if (mDensity == 240) {
//	       settings.setDefaultZoom(ZoomDensity.FAR);
//	       }
	       
	       webView.setWebViewClient(new WebViewClient(){
	           @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            // TODO Auto-generated method stub
	               //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
	             view.loadUrl(url);
	            return true;
	        }
	       });
	    }
}
