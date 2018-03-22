package info.androidhive.bottomsheet;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetActivity extends AppCompatActivity {
    private BottomSheetBehavior mBottomSheetBehavior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setAutoMeasureEnabled(true);
        ApplicationAdapter adapter = new ApplicationAdapter(this, listApplications(this));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        View peakView = findViewById(R.id.navigationview);
        //  mBottomSheetBehavior.setPeekHeight(peakView.getHeight());
        peakView.requestLayout();
        FrameLayout parentThatHasBottomSheetBehavior = (FrameLayout) recyclerView.getParent().getParent();
        mBottomSheetBehavior = BottomSheetBehavior.from(parentThatHasBottomSheetBehavior);
        if (mBottomSheetBehavior != null) {

            mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                @Override
                public void onStateChanged(@NonNull View bottomSheet, int newState) {
                    //setStateText(newState);
                }

                @Override
                public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                    // setOffsetText(slideOffset);
                }
            });
        }
    }



    public static int getStateAsString(int newState) {
        switch (newState) {
            case BottomSheetBehavior.STATE_COLLAPSED:
                return R.string.collapsed;
            case BottomSheetBehavior.STATE_DRAGGING:
                return R.string.dragging;
            case BottomSheetBehavior.STATE_EXPANDED:
                return R.string.expanded;
            case BottomSheetBehavior.STATE_HIDDEN:
                return R.string.hidden;
            case BottomSheetBehavior.STATE_SETTLING:
                return R.string.settling;
        }
        return R.string.undefined;
    }


    public static List<ApplicationInfo> listApplications(Context context) {
        int flags = PackageManager.GET_META_DATA;
        List<ApplicationInfo> installedApps = new ArrayList<>();
        PackageManager pm = context.getPackageManager();
        List<ApplicationInfo> applications = pm.getInstalledApplications(flags);
        for (ApplicationInfo appInfo : applications) {
            if ((appInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 1) {
                installedApps.add(appInfo);
            }
        }
        return installedApps;
    }
}
