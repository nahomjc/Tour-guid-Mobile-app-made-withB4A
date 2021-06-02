
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "b4a.example.main");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _cur = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
public static RemoteObject _buttonhotel = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonhospital = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttoncinema = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonsupermarket = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonrestaurants = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonschool = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonmall = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttoncurrency = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _spotlightmenu = RemoteObject.declareNull("b4a.example.spotlight");
public static RemoteObject _buttoninfo = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonqr = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonnearby = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static b4a.example.starter _starter = null;
public static b4a.example.type_list _type_list = null;
public static b4a.example.data _data = null;
public static b4a.example.data_from_db _data_from_db = null;
public static b4a.example.map _map = null;
public static b4a.example.currency _currency = null;
public static b4a.example.embassy _embassy = null;
public static b4a.example.one_day _one_day = null;
public static b4a.example.about_us _about_us = null;
  public Object[] GetGlobals() {
		return new Object[] {"about_us",Debug.moduleToString(b4a.example.about_us.class),"Activity",main.mostCurrent._activity,"Buttoncinema",main.mostCurrent._buttoncinema,"Buttoncurrency",main.mostCurrent._buttoncurrency,"Buttonhospital",main.mostCurrent._buttonhospital,"ButtonHotel",main.mostCurrent._buttonhotel,"Buttoninfo",main.mostCurrent._buttoninfo,"Buttonmall",main.mostCurrent._buttonmall,"Buttonnearby",main.mostCurrent._buttonnearby,"ButtonQR",main.mostCurrent._buttonqr,"Buttonrestaurants",main.mostCurrent._buttonrestaurants,"Buttonschool",main.mostCurrent._buttonschool,"Buttonsupermarket",main.mostCurrent._buttonsupermarket,"cur",main._cur,"currency",Debug.moduleToString(b4a.example.currency.class),"data",Debug.moduleToString(b4a.example.data.class),"data_from_db",Debug.moduleToString(b4a.example.data_from_db.class),"embassy",Debug.moduleToString(b4a.example.embassy.class),"Map",Debug.moduleToString(b4a.example.map.class),"one_day",Debug.moduleToString(b4a.example.one_day.class),"Panel1",main.mostCurrent._panel1,"Spotlightmenu",main.mostCurrent._spotlightmenu,"Starter",Debug.moduleToString(b4a.example.starter.class),"type_list",Debug.moduleToString(b4a.example.type_list.class)};
}
}