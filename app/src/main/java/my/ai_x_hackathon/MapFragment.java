package my.ai_x_hackathon;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import net.daum.android.map.MapViewEventListener;
import net.daum.android.map.MapViewTouchEventListener;
import net.daum.mf.map.api.CalloutBalloonAdapter;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPolyline;
import net.daum.mf.map.api.MapReverseGeoCoder;
import net.daum.mf.map.api.MapView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import my.ai_x_hackathon.R;

public class MapFragment extends Fragment implements MapView.MapViewEventListener, MapView.CurrentLocationEventListener, MapReverseGeoCoder.ReverseGeoCodingResultListener{

    public TextView address_text;

    // 커스텀 마커 풍선
    class CustomCalloutBalloonAdapter implements CalloutBalloonAdapter {
        private final View mCalloutBalloon;

        public CustomCalloutBalloonAdapter() {
            mCalloutBalloon = getLayoutInflater().inflate(R.layout.custom_callout_balloon, null);
        }

        @Override
        public View getCalloutBalloon(MapPOIItem poiItem) {
            ((TextView) mCalloutBalloon.findViewById(R.id.ball_tv_name)).setText(poiItem.getItemName());
            ((TextView) mCalloutBalloon.findViewById(R.id.ball_tv_address)).setText("Custom CalloutBalloon");
            return (View)mCalloutBalloon;
        }

        @Override
        public View getPressedCalloutBalloon(MapPOIItem poiItem) {
            return null;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_map,container,false);
        address_text = (TextView) v.findViewById(R.id.map_textView);

        MapView mapView1 = new MapView(this.getActivity());

        ViewGroup mapViewContainer = (ViewGroup) v.findViewById(R.id.map_view);
        mapViewContainer.addView(mapView1);
        mapView1.setMapViewEventListener(this);
        mapView1.setCalloutBalloonAdapter( new CustomCalloutBalloonAdapter());

        // 중심점 변경 - 북촌로 5가길
        mapView1.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.579324, 126.984503), true);
        mapView1.setZoomLevel(2, true); // 줌 레벨 변경
        mapView1.zoomIn(true);
        mapView1.zoomOut(true);


        // polyline1 그리기 ( 북촌로5가길 )
        MapPolyline polyline1 = new MapPolyline();
        polyline1.setTag(1000);
        polyline1.setLineColor(Color.argb(128, 255, 51, 0)); // Polyline 컬러 지정.
        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.581468, 126.981177));
        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.581262,126.981456));
        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.580860,126.981644));
        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.580576,126.981817));
        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.579962,126.982267));
        // Polyline 지도에 올리기.
        mapView1.addPolyline(polyline1);

        // marker1 추가하기 ( 북촌로 5가길 )
        MapPoint MARKER_POINT1 = MapPoint.mapPointWithGeoCoord(37.581444, 126.981217);

        MapPOIItem marker1 = new MapPOIItem();
        marker1.setItemName("북촌로 5가길");
        marker1.setTag(0);
        marker1.setMapPoint(MARKER_POINT1);
        marker1.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker1.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        mapView1.addPOIItem(marker1);

        // polyline2 그리기 ( 계동길 )
        MapPolyline polyline2 = new MapPolyline();
        polyline2.setTag(1001);
        polyline2.setLineColor(Color.argb(128, 0, 255, 0)); // Polyline 컬러 지정.
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.582910, 126.986846));
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.581640, 126.986770));
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.580236, 126.986736));
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.577503, 126.986773));
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.577277, 126.986822));
        // Polyline 지도에 올리기.
        mapView1.addPolyline(polyline2);

        // marker2 추가하기 ( 계동길 )
        MapPoint MARKER_POINT2 = MapPoint.mapPointWithGeoCoord(37.582880, 126.986843);

        MapPOIItem marker2 = new MapPOIItem();
        marker2.setItemName("계동길");
        marker2.setTag(1);
        marker2.setMapPoint(MARKER_POINT2);
        marker2.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker2.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        mapView1.addPOIItem(marker2);


        // polyline3 그리기 ( 율곡로3길 )
        MapPolyline polyline3 = new MapPolyline();
        polyline3.setTag(1003);
        polyline3.setLineColor(Color.argb(128, 0, 51, 255)); // Polyline 컬러 지정.
        polyline3.addPoint(MapPoint.mapPointWithGeoCoord(37.579399, 126.982142));
        polyline3.addPoint(MapPoint.mapPointWithGeoCoord(37.579041, 126.982142));
        polyline3.addPoint(MapPoint.mapPointWithGeoCoord(37.578700, 126.982101));
        polyline3.addPoint(MapPoint.mapPointWithGeoCoord(37.577983, 126.982339));
        polyline3.addPoint(MapPoint.mapPointWithGeoCoord(37.577511, 126.982449));
        polyline3.addPoint(MapPoint.mapPointWithGeoCoord(37.576800, 126.982575));
        polyline3.addPoint(MapPoint.mapPointWithGeoCoord(37.575929, 126.983001));
        // Polyline 지도에 올리기.
        mapView1.addPolyline(polyline3);

        // marker3 추가하기 ( 율곡로3길 )
        MapPoint MARKER_POINT3 = MapPoint.mapPointWithGeoCoord(37.579353, 126.982135);

        MapPOIItem marker3 = new MapPOIItem();
        marker3.setItemName("율곡로3길");
        marker3.setTag(2);
        marker3.setMapPoint(MARKER_POINT3);
        marker3.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker3.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        mapView1.addPOIItem(marker3);



        return v;
    }




    // 오버라이딩
    @Override
    public void onReverseGeoCoderFoundAddress(MapReverseGeoCoder mapReverseGeoCoder, String s) {
        address_text.setText(s);
    }

    @Override
    public void onReverseGeoCoderFailedToFindAddress(MapReverseGeoCoder mapReverseGeoCoder) {
        address_text.setText("탐색 실패..");
    }

    @Override
    public void onCurrentLocationUpdate(MapView mapView, MapPoint mapPoint, float v) {

    }

    @Override
    public void onCurrentLocationDeviceHeadingUpdate(MapView mapView, float v) {

    }

    @Override
    public void onCurrentLocationUpdateFailed(MapView mapView) {

    }

    @Override
    public void onCurrentLocationUpdateCancelled(MapView mapView) {

    }
    @Override
    public void onMapViewInitialized(MapView mapView) {
        MapReverseGeoCoder mReverseGeoCoder = new MapReverseGeoCoder("1d4323c50dde19d81811da07cf4191ca",
                mapView.getMapCenterPoint(),this,getActivity());
        mReverseGeoCoder.startFindingAddress();
    }

    @Override
    public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewZoomLevelChanged(MapView mapView, int i) {

    }

    @Override
    public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {

    }

    // 드래그가 끝나면 텍스트뷰에 주소 띄우기
    @Override
    public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {
        MapReverseGeoCoder mReverseGeoCoder = new MapReverseGeoCoder("1d4323c50dde19d81811da07cf4191ca",
                mapView.getMapCenterPoint(),this,getActivity());
        mReverseGeoCoder.startFindingAddress();
    }

    @Override
    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {

    }
}