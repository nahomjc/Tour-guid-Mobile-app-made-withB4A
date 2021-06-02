
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

public class data_from_db implements IRemote{
	public static data_from_db mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public data_from_db() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("data_from_db"), "b4a.example.data_from_db");
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
		pcBA = new PCBA(this, data_from_db.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _cn = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL");
public static RemoteObject _cur = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
public static RemoteObject _label1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _buttonmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _imageview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _h = RemoteObject.declareNull("wir.hitex.recycler.Hitex_RecyclerListView");
public static RemoteObject _hitex_parallaximageview1 = RemoteObject.declareNull("wir.hitex.recycler.Hitex_ParallaxImageView");
public static RemoteObject _buttonhome = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.type_list _type_list = null;
public static b4a.example.data _data = null;
public static b4a.example.map _map = null;
public static b4a.example.currency _currency = null;
public static b4a.example.embassy _embassy = null;
public static b4a.example.one_day _one_day = null;
public static b4a.example.about_us _about_us = null;
  public Object[] GetGlobals() {
		return new Object[] {"about_us",Debug.moduleToString(b4a.example.about_us.class),"Activity",data_from_db.mostCurrent._activity,"ButtonHome",data_from_db.mostCurrent._buttonhome,"Buttonmap",data_from_db.mostCurrent._buttonmap,"cn",data_from_db._cn,"cur",data_from_db._cur,"currency",Debug.moduleToString(b4a.example.currency.class),"data",Debug.moduleToString(b4a.example.data.class),"embassy",Debug.moduleToString(b4a.example.embassy.class),"h",data_from_db.mostCurrent._h,"Hitex_ParallaxImageView1",data_from_db.mostCurrent._hitex_parallaximageview1,"ImageView1",data_from_db.mostCurrent._imageview1,"Label1",data_from_db.mostCurrent._label1,"Label2",data_from_db.mostCurrent._label2,"Label4",data_from_db.mostCurrent._label4,"Main",Debug.moduleToString(b4a.example.main.class),"Map",Debug.moduleToString(b4a.example.map.class),"one_day",Debug.moduleToString(b4a.example.one_day.class),"Starter",Debug.moduleToString(b4a.example.starter.class),"type_list",Debug.moduleToString(b4a.example.type_list.class)};
}
}