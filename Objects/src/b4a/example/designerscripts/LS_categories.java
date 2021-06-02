package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_categories{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[categories/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 13;BA.debugLine="ButtonHotel.Top=0"[categories/General script]
views.get("buttonhotel").vw.setTop((int)(0d));
//BA.debugLineNum = 14;BA.debugLine="ButtonHotel.Left=0"[categories/General script]
views.get("buttonhotel").vw.setLeft((int)(0d));
//BA.debugLineNum = 15;BA.debugLine="ButtonHotel.Width=100%x/2"[categories/General script]
views.get("buttonhotel").vw.setWidth((int)((100d / 100 * width)/2d));
//BA.debugLineNum = 16;BA.debugLine="ButtonHotel.Height=100%y/4-160dip/4"[categories/General script]
views.get("buttonhotel").vw.setHeight((int)((100d / 100 * height)/4d-(160d * scale)/4d));
//BA.debugLineNum = 20;BA.debugLine="Buttonhospital.Top=ButtonHotel.Bottom"[categories/General script]
views.get("buttonhospital").vw.setTop((int)((views.get("buttonhotel").vw.getTop() + views.get("buttonhotel").vw.getHeight())));
//BA.debugLineNum = 21;BA.debugLine="Buttonhospital.Left=0"[categories/General script]
views.get("buttonhospital").vw.setLeft((int)(0d));
//BA.debugLineNum = 22;BA.debugLine="Buttonhospital.Width=100%x/2"[categories/General script]
views.get("buttonhospital").vw.setWidth((int)((100d / 100 * width)/2d));
//BA.debugLineNum = 23;BA.debugLine="Buttonhospital.Height=100%y/4-160dip/4"[categories/General script]
views.get("buttonhospital").vw.setHeight((int)((100d / 100 * height)/4d-(160d * scale)/4d));
//BA.debugLineNum = 26;BA.debugLine="Buttonrestaurants.Top=Buttonhospital.Bottom"[categories/General script]
views.get("buttonrestaurants").vw.setTop((int)((views.get("buttonhospital").vw.getTop() + views.get("buttonhospital").vw.getHeight())));
//BA.debugLineNum = 27;BA.debugLine="Buttonrestaurants.Left=0"[categories/General script]
views.get("buttonrestaurants").vw.setLeft((int)(0d));
//BA.debugLineNum = 28;BA.debugLine="Buttonrestaurants.Width=100%x/2"[categories/General script]
views.get("buttonrestaurants").vw.setWidth((int)((100d / 100 * width)/2d));
//BA.debugLineNum = 29;BA.debugLine="Buttonrestaurants.Height=100%y/4-160dip/4"[categories/General script]
views.get("buttonrestaurants").vw.setHeight((int)((100d / 100 * height)/4d-(160d * scale)/4d));
//BA.debugLineNum = 32;BA.debugLine="Buttonmall.Top=Buttonrestaurants.Bottom"[categories/General script]
views.get("buttonmall").vw.setTop((int)((views.get("buttonrestaurants").vw.getTop() + views.get("buttonrestaurants").vw.getHeight())));
//BA.debugLineNum = 33;BA.debugLine="Buttonmall.Left=0"[categories/General script]
views.get("buttonmall").vw.setLeft((int)(0d));
//BA.debugLineNum = 34;BA.debugLine="Buttonmall.Width=ButtonHotel.Width"[categories/General script]
views.get("buttonmall").vw.setWidth((int)((views.get("buttonhotel").vw.getWidth())));
//BA.debugLineNum = 35;BA.debugLine="Buttonmall.Height=ButtonHotel.Height"[categories/General script]
views.get("buttonmall").vw.setHeight((int)((views.get("buttonhotel").vw.getHeight())));
//BA.debugLineNum = 42;BA.debugLine="Buttoncinema.Top=ButtonHotel.Top"[categories/General script]
views.get("buttoncinema").vw.setTop((int)((views.get("buttonhotel").vw.getTop())));
//BA.debugLineNum = 43;BA.debugLine="Buttoncinema.Left=100%x/2"[categories/General script]
views.get("buttoncinema").vw.setLeft((int)((100d / 100 * width)/2d));
//BA.debugLineNum = 44;BA.debugLine="Buttoncinema.Width=ButtonHotel.Width"[categories/General script]
views.get("buttoncinema").vw.setWidth((int)((views.get("buttonhotel").vw.getWidth())));
//BA.debugLineNum = 45;BA.debugLine="Buttoncinema.Height=ButtonHotel.Height"[categories/General script]
views.get("buttoncinema").vw.setHeight((int)((views.get("buttonhotel").vw.getHeight())));
//BA.debugLineNum = 48;BA.debugLine="Buttonsupermarket.Top=Buttonhospital.Top"[categories/General script]
views.get("buttonsupermarket").vw.setTop((int)((views.get("buttonhospital").vw.getTop())));
//BA.debugLineNum = 49;BA.debugLine="Buttonsupermarket.Left=100%x/2"[categories/General script]
views.get("buttonsupermarket").vw.setLeft((int)((100d / 100 * width)/2d));
//BA.debugLineNum = 50;BA.debugLine="Buttonsupermarket.Width=ButtonHotel.Width"[categories/General script]
views.get("buttonsupermarket").vw.setWidth((int)((views.get("buttonhotel").vw.getWidth())));
//BA.debugLineNum = 51;BA.debugLine="Buttonsupermarket.Height=ButtonHotel.Height"[categories/General script]
views.get("buttonsupermarket").vw.setHeight((int)((views.get("buttonhotel").vw.getHeight())));
//BA.debugLineNum = 54;BA.debugLine="Buttonschool.Top=Buttonrestaurants.Top"[categories/General script]
views.get("buttonschool").vw.setTop((int)((views.get("buttonrestaurants").vw.getTop())));
//BA.debugLineNum = 55;BA.debugLine="Buttonschool.Left=100%x/2"[categories/General script]
views.get("buttonschool").vw.setLeft((int)((100d / 100 * width)/2d));
//BA.debugLineNum = 56;BA.debugLine="Buttonschool.Width=ButtonHotel.Width"[categories/General script]
views.get("buttonschool").vw.setWidth((int)((views.get("buttonhotel").vw.getWidth())));
//BA.debugLineNum = 57;BA.debugLine="Buttonschool.Height=ButtonHotel.Height"[categories/General script]
views.get("buttonschool").vw.setHeight((int)((views.get("buttonhotel").vw.getHeight())));
//BA.debugLineNum = 60;BA.debugLine="Buttoncurrency.Top=Buttonmall.Top"[categories/General script]
views.get("buttoncurrency").vw.setTop((int)((views.get("buttonmall").vw.getTop())));
//BA.debugLineNum = 61;BA.debugLine="Buttoncurrency.Left=100%x/2"[categories/General script]
views.get("buttoncurrency").vw.setLeft((int)((100d / 100 * width)/2d));
//BA.debugLineNum = 62;BA.debugLine="Buttoncurrency.Width=ButtonHotel.Width"[categories/General script]
views.get("buttoncurrency").vw.setWidth((int)((views.get("buttonhotel").vw.getWidth())));
//BA.debugLineNum = 63;BA.debugLine="Buttoncurrency.Height=ButtonHotel.Height"[categories/General script]
views.get("buttoncurrency").vw.setHeight((int)((views.get("buttonhotel").vw.getHeight())));

}
}