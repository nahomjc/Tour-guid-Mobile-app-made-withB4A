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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (main) Resume **");
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
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (type_list.mostCurrent != null);
vis = vis | (data_from_db.mostCurrent != null);
vis = vis | (map.mostCurrent != null);
vis = vis | (currency.mostCurrent != null);
vis = vis | (embassy.mostCurrent != null);
vis = vis | (one_day.mostCurrent != null);
vis = vis | (about_us.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
 {
            Activity __a = null;
            if (type_list.previousOne != null) {
				__a = type_list.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(type_list.mostCurrent == null ? null : type_list.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (data_from_db.previousOne != null) {
				__a = data_from_db.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(data_from_db.mostCurrent == null ? null : data_from_db.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (map.previousOne != null) {
				__a = map.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(map.mostCurrent == null ? null : map.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (currency.previousOne != null) {
				__a = currency.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(currency.mostCurrent == null ? null : currency.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (embassy.previousOne != null) {
				__a = embassy.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(embassy.mostCurrent == null ? null : embassy.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (one_day.previousOne != null) {
				__a = one_day.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(one_day.mostCurrent == null ? null : one_day.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (about_us.previousOne != null) {
				__a = about_us.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(about_us.mostCurrent == null ? null : about_us.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.sql.SQL.CursorWrapper _cur = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonhotel = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonhospital = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttoncinema = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonsupermarket = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonrestaurants = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonschool = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonmall = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttoncurrency = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public b4a.example.spotlight _spotlightmenu = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttoninfo = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonqr = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonnearby = null;
public b4a.example.starter _starter = null;
public b4a.example.type_list _type_list = null;
public b4a.example.data _data = null;
public b4a.example.data_from_db _data_from_db = null;
public b4a.example.map _map = null;
public b4a.example.currency _currency = null;
public b4a.example.embassy _embassy = null;
public b4a.example.one_day _one_day = null;
public b4a.example.about_us _about_us = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Activity.LoadLayout(\"categories\")";
mostCurrent._activity.LoadLayout("categories",mostCurrent.activityBA);
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="Spotlightmenu.Initialize(Me,\"Spotlightmenu\",5%y,F";
mostCurrent._spotlightmenu._initialize(mostCurrent.activityBA,main.getObject(),"Spotlightmenu",(float) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (5),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.False,anywheresoftware.b4a.keywords.Common.False,anywheresoftware.b4a.keywords.Common.True,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._buttoninfo.getObject())),mostCurrent._activity);
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="Spotlightmenu.additem(\"taxi and train\",Colors.Bla";
mostCurrent._spotlightmenu._additem("taxi and train",anywheresoftware.b4a.keywords.Common.Colors.Black,(int) (15),anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Taxi.png"));
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="Spotlightmenu.additem(\"airlines\",Colors.Black,15,";
mostCurrent._spotlightmenu._additem("airlines",anywheresoftware.b4a.keywords.Common.Colors.Black,(int) (15),anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"arf.png"));
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="Spotlightmenu.additem(\"one day\",Colors.Black,15,L";
mostCurrent._spotlightmenu._additem("one day",anywheresoftware.b4a.keywords.Common.Colors.Black,(int) (15),anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"download.jpg"));
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="Spotlightmenu.additem(\"embassy\",Colors.Black,15,L";
mostCurrent._spotlightmenu._additem("embassy",anywheresoftware.b4a.keywords.Common.Colors.Black,(int) (15),anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"embassy cate2.jpg"));
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress"))
	return (Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode});
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Select KeyCode";
switch (BA.switchObjectToInt(_keycode,anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK)) {
case 0: {
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="If Spotlightmenu.isOpen Then Spotlightmenu.dism";
if (mostCurrent._spotlightmenu._isopen()) { 
mostCurrent._spotlightmenu._dismiss();}
else {
mostCurrent._activity.Finish();};
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 break; }
}
;
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static String  _buttoncinema_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttoncinema_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "buttoncinema_click", null);
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub Buttoncinema_Click";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="data.type=\"cinema\"";
mostCurrent._data._type = "cinema";
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="StartActivity(type_list)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._type_list.getObject()));
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="End Sub";
return "";
}
public static String  _buttoncurrency_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttoncurrency_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "buttoncurrency_click", null);
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub Buttoncurrency_Click";
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="data.Type=\"currency\"";
mostCurrent._data._type = "currency";
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="StartActivity(currency)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._currency.getObject()));
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="End Sub";
return "";
}
public static String  _buttonhospital_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonhospital_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "buttonhospital_click", null);
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub Buttonhospital_Click";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="data.type=\"hospital\"";
mostCurrent._data._type = "hospital";
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="StartActivity(type_list)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._type_list.getObject()));
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="End Sub";
return "";
}
public static String  _buttonhotel_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonhotel_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "buttonhotel_click", null);
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub ButtonHotel_Click";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="data.type=\"hotel\"";
mostCurrent._data._type = "hotel";
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="StartActivity(type_list)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._type_list.getObject()));
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="End Sub";
return "";
}
public static String  _buttoninfo_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttoninfo_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "buttoninfo_click", null);
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub Buttoninfo_Click";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="Spotlightmenu.show";
mostCurrent._spotlightmenu._show();
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="End Sub";
return "";
}
public static String  _buttonmall_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonmall_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "buttonmall_click", null);
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub Buttonmall_Click";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="data.Type=\"mall\"";
mostCurrent._data._type = "mall";
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="StartActivity(type_list)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._type_list.getObject()));
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="End Sub";
return "";
}
public static String  _buttonnearby_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonnearby_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "buttonnearby_click", null);
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub Buttonnearby_Click";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="StartActivity(one_day)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._one_day.getObject()));
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="End Sub";
return "";
}
public static String  _buttonqr_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonqr_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "buttonqr_click", null);
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub ButtonQR_Click";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="StartActivity(about_us)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._about_us.getObject()));
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="End Sub";
return "";
}
public static String  _buttonrestaurants_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonrestaurants_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "buttonrestaurants_click", null);
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub Buttonrestaurants_Click";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="data.type=\"restaurants\"";
mostCurrent._data._type = "restaurants";
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="StartActivity(type_list)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._type_list.getObject()));
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="End Sub";
return "";
}
public static String  _buttonschool_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonschool_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "buttonschool_click", null);
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub Buttonschool_Click";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="data.type=\"school\"";
mostCurrent._data._type = "school";
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="StartActivity(type_list)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._type_list.getObject()));
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="End Sub";
return "";
}
public static String  _buttonsupermarket_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonsupermarket_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "buttonsupermarket_click", null);
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub Buttonsupermarket_Click";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="data.type=\"supermarket\"";
mostCurrent._data._type = "supermarket";
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="StartActivity(type_list)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._type_list.getObject()));
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="End Sub";
return "";
}
public static String  _spotlightmenu_click(int _index) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "spotlightmenu_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "spotlightmenu_click", new Object[] {_index});
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub Spotlightmenu_Click(index As Int)";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Select index";
switch (_index) {
case 0: {
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="data.Type=\"taxi\"";
mostCurrent._data._type = "taxi";
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="StartActivity(type_list)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._type_list.getObject()));
 break; }
case 1: {
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="data.Type=\"airlines\"";
mostCurrent._data._type = "airlines";
RDebugUtils.currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="StartActivity(type_list)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._type_list.getObject()));
 break; }
case 2: {
RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="data.Type=\"one_day\"";
mostCurrent._data._type = "one_day";
RDebugUtils.currentLine=720906;
 //BA.debugLineNum = 720906;BA.debugLine="StartActivity(type_list)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._type_list.getObject()));
 break; }
case 3: {
RDebugUtils.currentLine=720908;
 //BA.debugLineNum = 720908;BA.debugLine="data.Type=\"embassy\"";
mostCurrent._data._type = "embassy";
RDebugUtils.currentLine=720909;
 //BA.debugLineNum = 720909;BA.debugLine="StartActivity(Map)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._map.getObject()));
RDebugUtils.currentLine=720910;
 //BA.debugLineNum = 720910;BA.debugLine="ToastMessageShow(\"to open you have to opne the";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("to open you have to opne the internet..."),anywheresoftware.b4a.keywords.Common.False);
 break; }
}
;
RDebugUtils.currentLine=720915;
 //BA.debugLineNum = 720915;BA.debugLine="End Sub";
return "";
}
}