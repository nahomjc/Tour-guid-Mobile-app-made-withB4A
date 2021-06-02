
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

public class starter implements IRemote{
	public static starter mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public starter() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("starter"), "b4a.example.starter");
	}
     public static RemoteObject getObject() {
		return myClass;
	 }
	public RemoteObject _service;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
        _service = (RemoteObject) args[2];
        remoteMe = RemoteObject.declareNull("b4a.example.starter");
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[3];
		pcBA = new PCBA(this, starter.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static b4a.example.main _main = null;
public static b4a.example.type_list _type_list = null;
public static b4a.example.data _data = null;
public static b4a.example.data_from_db _data_from_db = null;
public static b4a.example.map _map = null;
public static b4a.example.currency _currency = null;
public static b4a.example.embassy _embassy = null;
public static b4a.example.one_day _one_day = null;
public static b4a.example.about_us _about_us = null;
  public Object[] GetGlobals() {
		return new Object[] {"about_us",Debug.moduleToString(b4a.example.about_us.class),"currency",Debug.moduleToString(b4a.example.currency.class),"data",Debug.moduleToString(b4a.example.data.class),"data_from_db",Debug.moduleToString(b4a.example.data_from_db.class),"embassy",Debug.moduleToString(b4a.example.embassy.class),"Main",Debug.moduleToString(b4a.example.main.class),"Map",Debug.moduleToString(b4a.example.map.class),"one_day",Debug.moduleToString(b4a.example.one_day.class),"Service",starter.mostCurrent._service,"type_list",Debug.moduleToString(b4a.example.type_list.class)};
}
}