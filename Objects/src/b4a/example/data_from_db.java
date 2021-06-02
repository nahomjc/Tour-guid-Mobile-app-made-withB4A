package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class data_from_db extends Activity implements B4AActivity{
	public static data_from_db mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.data_from_db");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (data_from_db).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.data_from_db");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.data_from_db", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (data_from_db) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (data_from_db) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return data_from_db.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (data_from_db) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (data_from_db) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.sql.SQL _cn = null;
public static anywheresoftware.b4a.sql.SQL.CursorWrapper _cur = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label4 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonmap = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview1 = null;
public wir.hitex.recycler.Hitex_RecyclerListView _h = null;
public wir.hitex.recycler.Hitex_ParallaxImageView _hitex_parallaximageview1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonhome = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.type_list _type_list = null;
public b4a.example.data _data = null;
public b4a.example.map _map = null;
public b4a.example.currency _currency = null;
public b4a.example.embassy _embassy = null;
public b4a.example.one_day _one_day = null;
public b4a.example.about_us _about_us = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="data_from_db";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=2293763;
 //BA.debugLineNum = 2293763;BA.debugLine="Activity.LoadLayout(\"data_from_db\")";
mostCurrent._activity.LoadLayout("data_from_db",mostCurrent.activityBA);
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="Activity.Color = 0xFFFAFAFA";
mostCurrent._activity.setColor((int) (0xfffafafa));
RDebugUtils.currentLine=2293767;
 //BA.debugLineNum = 2293767;BA.debugLine="If File.Exists(File.DirInternal, \"ahnr.db\") = Fal";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ahnr.db")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2293768;
 //BA.debugLineNum = 2293768;BA.debugLine="File.Copy(File.DirAssets, \"ahnr.db\", File.DirInt";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ahnr.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ahnr.db");
 };
RDebugUtils.currentLine=2293771;
 //BA.debugLineNum = 2293771;BA.debugLine="cn.Initialize(File.DirInternal, \"ahnr.db\", False)";
_cn.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ahnr.db",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2293773;
 //BA.debugLineNum = 2293773;BA.debugLine="h.Initializer(\"h\").Header.Build";
mostCurrent._h.Initializer(mostCurrent.activityBA,"h").Header().Build();
RDebugUtils.currentLine=2293774;
 //BA.debugLineNum = 2293774;BA.debugLine="h.HeaderPanel.LoadLayout(\"header\")";
mostCurrent._h.getHeaderPanel().LoadLayout("header",mostCurrent.activityBA);
RDebugUtils.currentLine=2293775;
 //BA.debugLineNum = 2293775;BA.debugLine="h.Height=47%y";
mostCurrent._h.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (47),mostCurrent.activityBA));
RDebugUtils.currentLine=2293776;
 //BA.debugLineNum = 2293776;BA.debugLine="h.HeaderPanel.Color=Colors.Blue";
mostCurrent._h.getHeaderPanel().setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
RDebugUtils.currentLine=2293777;
 //BA.debugLineNum = 2293777;BA.debugLine="Hitex_ParallaxImageView1.Width=100%x";
mostCurrent._hitex_parallaximageview1.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=2293778;
 //BA.debugLineNum = 2293778;BA.debugLine="Hitex_ParallaxImageView1.Top=0";
mostCurrent._hitex_parallaximageview1.setTop((int) (0));
RDebugUtils.currentLine=2293779;
 //BA.debugLineNum = 2293779;BA.debugLine="Hitex_ParallaxImageView1.Left=0";
mostCurrent._hitex_parallaximageview1.setLeft((int) (0));
RDebugUtils.currentLine=2293780;
 //BA.debugLineNum = 2293780;BA.debugLine="Hitex_ParallaxImageView1.Height=h.Height";
mostCurrent._hitex_parallaximageview1.setHeight(mostCurrent._h.getHeight());
RDebugUtils.currentLine=2293781;
 //BA.debugLineNum = 2293781;BA.debugLine="Hitex_ParallaxImageView1.SetParallaxStyles(Hitex";
mostCurrent._hitex_parallaximageview1.SetParallaxStyles(mostCurrent._hitex_parallaximageview1.Style_VerticalAlpha);
RDebugUtils.currentLine=2293782;
 //BA.debugLineNum = 2293782;BA.debugLine="Activity.AddView(h,0,56dip,-1,100%y-56dip)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._h.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (56)),(int) (-1),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (56))));
RDebugUtils.currentLine=2293784;
 //BA.debugLineNum = 2293784;BA.debugLine="h.Gravity = Gravity.LEFT";
mostCurrent._h.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.LEFT);
RDebugUtils.currentLine=2293785;
 //BA.debugLineNum = 2293785;BA.debugLine="loa";
_loa();
RDebugUtils.currentLine=2293787;
 //BA.debugLineNum = 2293787;BA.debugLine="h.Show(h.ANIMATION_ALPHAIN,1000,False)";
mostCurrent._h.Show(mostCurrent._h.ANIMATION_ALPHAIN,(int) (1000),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2293790;
 //BA.debugLineNum = 2293790;BA.debugLine="h.Divider.Add1(Colors.White,1dip)";
mostCurrent._h.Divider().Add1(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)));
RDebugUtils.currentLine=2293791;
 //BA.debugLineNum = 2293791;BA.debugLine="load";
_load();
RDebugUtils.currentLine=2293793;
 //BA.debugLineNum = 2293793;BA.debugLine="image";
_image();
RDebugUtils.currentLine=2293794;
 //BA.debugLineNum = 2293794;BA.debugLine="End Sub";
return "";
}
public static String  _loa() throws Exception{
RDebugUtils.currentModule="data_from_db";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loa"))
	return (String) Debug.delegate(mostCurrent.activityBA, "loa", null);
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor1 = null;
int _i = 0;
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub loa";
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="Dim Cursor1 As Cursor";
_cursor1 = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="Try";
try {RDebugUtils.currentLine=2490374;
 //BA.debugLineNum = 2490374;BA.debugLine="Cursor1 = cn.ExecQuery(\"SELECT * FROM '\"&data.ty";
_cursor1.setObject((android.database.Cursor)(_cn.ExecQuery("SELECT * FROM '"+mostCurrent._data._type+"'where name ='"+mostCurrent._data._r+"'")));
RDebugUtils.currentLine=2490375;
 //BA.debugLineNum = 2490375;BA.debugLine="For i = 0 To Cursor1.RowCount - 1";
{
final int step4 = 1;
final int limit4 = (int) (_cursor1.getRowCount()-1);
_i = (int) (0) ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
RDebugUtils.currentLine=2490376;
 //BA.debugLineNum = 2490376;BA.debugLine="Cursor1.Position = i";
_cursor1.setPosition(_i);
RDebugUtils.currentLine=2490379;
 //BA.debugLineNum = 2490379;BA.debugLine="h.AddTwoLines2(\"About\",Cursor1.GetString(\"descr";
mostCurrent._h.AddTwoLines2("About",_cursor1.GetString("description"),(Object)(1));
RDebugUtils.currentLine=2490380;
 //BA.debugLineNum = 2490380;BA.debugLine="h.AddTwoLines2(\"Phone \", Cursor1.GetString(\"pho";
mostCurrent._h.AddTwoLines2("Phone ",_cursor1.GetString("phone"),(Object)(2));
RDebugUtils.currentLine=2490381;
 //BA.debugLineNum = 2490381;BA.debugLine="h.AddTwoLines2(\"Website \",Cursor1.GetString(\"si";
mostCurrent._h.AddTwoLines2("Website ",_cursor1.GetString("site"),(Object)(3));
 }
};
 } 
       catch (Exception e11) {
			processBA.setLastException(e11);RDebugUtils.currentLine=2490387;
 //BA.debugLineNum = 2490387;BA.debugLine="ToastMessageShow(\"Nothing found\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Nothing found"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=2490391;
 //BA.debugLineNum = 2490391;BA.debugLine="End Sub";
return "";
}
public static String  _load() throws Exception{
RDebugUtils.currentModule="data_from_db";
if (Debug.shouldDelegate(mostCurrent.activityBA, "load"))
	return (String) Debug.delegate(mostCurrent.activityBA, "load", null);
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
int _i = 0;
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub load";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="Dim Cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="Cursor = cn.ExecQuery(\"SELECT name,phone,descript";
_cursor.setObject((android.database.Cursor)(_cn.ExecQuery("SELECT name,phone,description,site FROM '"+mostCurrent._data._type+"' where name LIKE '%"+mostCurrent._data._r+"%'")));
RDebugUtils.currentLine=2621446;
 //BA.debugLineNum = 2621446;BA.debugLine="For i = 0 To Cursor.RowCount - 1";
{
final int step3 = 1;
final int limit3 = (int) (_cursor.getRowCount()-1);
_i = (int) (0) ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
RDebugUtils.currentLine=2621447;
 //BA.debugLineNum = 2621447;BA.debugLine="Cursor.Position = i";
_cursor.setPosition(_i);
 }
};
RDebugUtils.currentLine=2621449;
 //BA.debugLineNum = 2621449;BA.debugLine="End Sub";
return "";
}
public static String  _image() throws Exception{
RDebugUtils.currentModule="data_from_db";
if (Debug.shouldDelegate(mostCurrent.activityBA, "image"))
	return (String) Debug.delegate(mostCurrent.activityBA, "image", null);
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
byte[] _buffer = null;
int _i = 0;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub image";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="Dim Cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="Dim buffer() As Byte";
_buffer = new byte[(int) (0)];
;
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="Cursor = cn.ExecQuery(\"SELECT photo FROM '\"&data.";
_cursor.setObject((android.database.Cursor)(_cn.ExecQuery("SELECT photo FROM '"+mostCurrent._data._type+"' where name='"+mostCurrent._data._r+"'")));
RDebugUtils.currentLine=3080196;
 //BA.debugLineNum = 3080196;BA.debugLine="For i = 0 To Cursor.RowCount - 1";
{
final int step4 = 1;
final int limit4 = (int) (_cursor.getRowCount()-1);
_i = (int) (0) ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
RDebugUtils.currentLine=3080197;
 //BA.debugLineNum = 3080197;BA.debugLine="Cursor.Position = i";
_cursor.setPosition(_i);
RDebugUtils.currentLine=3080198;
 //BA.debugLineNum = 3080198;BA.debugLine="buffer=Cursor.GetBlob(\"photo\")";
_buffer = _cursor.GetBlob("photo");
 }
};
RDebugUtils.currentLine=3080201;
 //BA.debugLineNum = 3080201;BA.debugLine="Dim in As InputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
RDebugUtils.currentLine=3080202;
 //BA.debugLineNum = 3080202;BA.debugLine="in.InitializeFromBytesArray(buffer, 0, buffer.Len";
_in.InitializeFromBytesArray(_buffer,(int) (0),_buffer.length);
RDebugUtils.currentLine=3080203;
 //BA.debugLineNum = 3080203;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=3080204;
 //BA.debugLineNum = 3080204;BA.debugLine="bmp.Initialize2(in)";
_bmp.Initialize2((java.io.InputStream)(_in.getObject()));
RDebugUtils.currentLine=3080205;
 //BA.debugLineNum = 3080205;BA.debugLine="Hitex_ParallaxImageView1.ImageBitmap=bmp";
mostCurrent._hitex_parallaximageview1.setImageBitmap(_bmp);
RDebugUtils.currentLine=3080208;
 //BA.debugLineNum = 3080208;BA.debugLine="in.Close";
_in.Close();
RDebugUtils.currentLine=3080209;
 //BA.debugLineNum = 3080209;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="data_from_db";
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="data_from_db";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="End Sub";
return "";
}
public static String  _buttonback_click() throws Exception{
RDebugUtils.currentModule="data_from_db";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonback_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "buttonback_click", null);
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Sub Buttonback_Click";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="StartActivity(type_list)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._type_list.getObject()));
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="End Sub";
return "";
}
public static String  _buttonhome_click() throws Exception{
RDebugUtils.currentModule="data_from_db";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonhome_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "buttonhome_click", null);
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub ButtonHome_Click";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="End Sub";
return "";
}
public static String  _buttonmap_click() throws Exception{
RDebugUtils.currentModule="data_from_db";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonmap_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "buttonmap_click", null);
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
int _i = 0;
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Sub Buttonmap_Click";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="Dim Cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="Cursor = cn.ExecQuery(\"SELECT map FROM '\"&data.ty";
_cursor.setObject((android.database.Cursor)(_cn.ExecQuery("SELECT map FROM '"+mostCurrent._data._type+"' where name='"+mostCurrent._data._r+"' ")));
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="For i = 0 To Cursor.RowCount - 1";
{
final int step3 = 1;
final int limit3 = (int) (_cursor.getRowCount()-1);
_i = (int) (0) ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="Cursor.Position = i";
_cursor.setPosition(_i);
RDebugUtils.currentLine=2949125;
 //BA.debugLineNum = 2949125;BA.debugLine="data.lat=Cursor.GetString(\"map\")";
mostCurrent._data._lat = _cursor.GetString("map");
 }
};
RDebugUtils.currentLine=2949129;
 //BA.debugLineNum = 2949129;BA.debugLine="StartActivity(Map) 'for webview map";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._map.getObject()));
RDebugUtils.currentLine=2949130;
 //BA.debugLineNum = 2949130;BA.debugLine="End Sub";
return "";
}
public static String  _h_itemclick(int _position,String _title,Object _returnvalue) throws Exception{
RDebugUtils.currentModule="data_from_db";
if (Debug.shouldDelegate(mostCurrent.activityBA, "h_itemclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "h_itemclick", new Object[] {_position,_title,_returnvalue});
anywheresoftware.b4a.objects.IntentWrapper _s = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
int _i = 0;
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub h_ItemClick (Position As Int, Title As String,";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="Dim s As Intent";
_s = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="Select ReturnValue";
switch (BA.switchObjectToInt(_returnvalue,(Object)(2),(Object)(3),(Object)(4))) {
case 0: {
RDebugUtils.currentLine=2555909;
 //BA.debugLineNum = 2555909;BA.debugLine="Dim Cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=2555910;
 //BA.debugLineNum = 2555910;BA.debugLine="Cursor = cn.ExecQuery(\"SELECT phone FROM '\"&dat";
_cursor.setObject((android.database.Cursor)(_cn.ExecQuery("SELECT phone FROM '"+mostCurrent._data._type+"' where name='"+mostCurrent._data._r+"' ")));
RDebugUtils.currentLine=2555911;
 //BA.debugLineNum = 2555911;BA.debugLine="For i = 0 To Cursor.RowCount - 1";
{
final int step6 = 1;
final int limit6 = (int) (_cursor.getRowCount()-1);
_i = (int) (0) ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
RDebugUtils.currentLine=2555912;
 //BA.debugLineNum = 2555912;BA.debugLine="Cursor.Position = i";
_cursor.setPosition(_i);
RDebugUtils.currentLine=2555913;
 //BA.debugLineNum = 2555913;BA.debugLine="data.lat=Cursor.GetString(\"phone\")";
mostCurrent._data._lat = _cursor.GetString("phone");
 }
};
RDebugUtils.currentLine=2555916;
 //BA.debugLineNum = 2555916;BA.debugLine="s.Initialize(s.ACTION_VIEW,\"tel:+251911245434\")";
_s.Initialize(_s.ACTION_VIEW,"tel:+251911245434");
RDebugUtils.currentLine=2555917;
 //BA.debugLineNum = 2555917;BA.debugLine="StartActivity(s)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_s.getObject()));
 break; }
case 1: {
RDebugUtils.currentLine=2555921;
 //BA.debugLineNum = 2555921;BA.debugLine="Dim Cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=2555922;
 //BA.debugLineNum = 2555922;BA.debugLine="Cursor = cn.ExecQuery(\"SELECT site FROM '\"&data";
_cursor.setObject((android.database.Cursor)(_cn.ExecQuery("SELECT site FROM '"+mostCurrent._data._type+"' where name='"+mostCurrent._data._r+"' ")));
RDebugUtils.currentLine=2555923;
 //BA.debugLineNum = 2555923;BA.debugLine="For i = 0 To Cursor.RowCount - 1";
{
final int step15 = 1;
final int limit15 = (int) (_cursor.getRowCount()-1);
_i = (int) (0) ;
for (;(step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15) ;_i = ((int)(0 + _i + step15))  ) {
RDebugUtils.currentLine=2555924;
 //BA.debugLineNum = 2555924;BA.debugLine="Cursor.Position = i";
_cursor.setPosition(_i);
RDebugUtils.currentLine=2555925;
 //BA.debugLineNum = 2555925;BA.debugLine="data.lat=Cursor.GetString(\"site\")";
mostCurrent._data._lat = _cursor.GetString("site");
 }
};
RDebugUtils.currentLine=2555929;
 //BA.debugLineNum = 2555929;BA.debugLine="StartActivity(Map) 'webview";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._map.getObject()));
 break; }
case 2: {
RDebugUtils.currentLine=2555931;
 //BA.debugLineNum = 2555931;BA.debugLine="Msgbox(\"\",\"ddd\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence(""),BA.ObjectToCharSequence("ddd"),mostCurrent.activityBA);
 break; }
}
;
RDebugUtils.currentLine=2555935;
 //BA.debugLineNum = 2555935;BA.debugLine="End Sub";
return "";
}
public static String  _label1_click() throws Exception{
RDebugUtils.currentModule="data_from_db";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label1_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "label1_click", null);
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub Label1_Click";
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="End Sub";
return "";
}
public static String  _label1_longclick() throws Exception{
RDebugUtils.currentModule="data_from_db";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label1_longclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "label1_longclick", null);
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub Label1_LongClick";
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="End Sub";
return "";
}
public static String  _label2_click() throws Exception{
RDebugUtils.currentModule="data_from_db";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label2_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "label2_click", null);
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub Label2_Click";
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="End Sub";
return "";
}
public static String  _label3_click() throws Exception{
RDebugUtils.currentModule="data_from_db";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label3_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "label3_click", null);
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub Label3_Click";
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="End Sub";
return "";
}
public static String  _label4_click() throws Exception{
RDebugUtils.currentModule="data_from_db";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label4_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "label4_click", null);
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
int _i = 0;
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub Label4_Click";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="Dim Cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="Cursor = cn.ExecQuery(\"SELECT site FROM '\"&data.t";
_cursor.setObject((android.database.Cursor)(_cn.ExecQuery("SELECT site FROM '"+mostCurrent._data._type+"' where name='"+mostCurrent._data._r+"' ")));
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="For i = 0 To Cursor.RowCount - 1";
{
final int step3 = 1;
final int limit3 = (int) (_cursor.getRowCount()-1);
_i = (int) (0) ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="Cursor.Position = i";
_cursor.setPosition(_i);
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="data.lat=Cursor.GetString(\"site\")";
mostCurrent._data._lat = _cursor.GetString("site");
 }
};
RDebugUtils.currentLine=2883593;
 //BA.debugLineNum = 2883593;BA.debugLine="StartActivity(Map)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._map.getObject()));
RDebugUtils.currentLine=2883594;
 //BA.debugLineNum = 2883594;BA.debugLine="End Sub";
return "";
}
}