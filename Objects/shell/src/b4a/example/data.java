
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

public class data implements IRemote{
	public static data mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public data() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, data.class);
    static {
		mostCurrent = new data();
        remoteMe = RemoteObject.declareNull("b4a.example.data");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("data"), "b4a.example.data");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("b4a.example.data"), new java.lang.ref.WeakReference<PCBA> (pcBA));
	}
   
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public PCBA create(Object[] args) throws ClassNotFoundException{
        throw new RuntimeException("CREATE is not supported.");
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _r = RemoteObject.createImmutable("");
public static RemoteObject _lat = RemoteObject.createImmutable("");
public static RemoteObject _lon = RemoteObject.createImmutable("");
public static RemoteObject _type = RemoteObject.createImmutable("");
public static RemoteObject _im = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
public static RemoteObject _s = RemoteObject.createImmutable("");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.type_list _type_list = null;
public static b4a.example.data_from_db _data_from_db = null;
public static b4a.example.map _map = null;
public static b4a.example.currency _currency = null;
public static b4a.example.embassy _embassy = null;
public static b4a.example.one_day _one_day = null;
public static b4a.example.about_us _about_us = null;
  public Object[] GetGlobals() {
		return new Object[] {"about_us",Debug.moduleToString(b4a.example.about_us.class),"currency",Debug.moduleToString(b4a.example.currency.class),"data_from_db",Debug.moduleToString(b4a.example.data_from_db.class),"embassy",Debug.moduleToString(b4a.example.embassy.class),"im",data._im,"lat",data._lat,"lon",data._lon,"Main",Debug.moduleToString(b4a.example.main.class),"Map",Debug.moduleToString(b4a.example.map.class),"one_day",Debug.moduleToString(b4a.example.one_day.class),"r",data._r,"s",data._s,"Starter",Debug.moduleToString(b4a.example.starter.class),"Type",data._type,"type_list",Debug.moduleToString(b4a.example.type_list.class)};
}
}