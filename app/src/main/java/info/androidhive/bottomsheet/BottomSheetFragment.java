package info.androidhive.bottomsheet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BottomSheetFragment extends BottomSheetDialogFragment {

    @BindView(R.id.rv_discount_coupon)
    RecyclerView rvDiscountCoupon;

    @BindView(R.id.navigation)
    BottomNavigationView navigationView;
    private BottomSheetAdapter adapter;

    private List<Coupons> couponsList;


    public BottomSheetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container, false);

        ButterKnife.bind(this, view);

        rvDiscountCoupon.setLayoutManager(new LinearLayoutManager(getContext()));
        
        couponsList = new ArrayList<>();
        Coupons coupons = new Coupons();
        for (int i = 0; i < 10; i++) {
          coupons.setName("Will Mel Coupon");
          coupons.setAmount("Ks - 20,000");
          coupons.setDescription("Save us to Ks-20,000 on orders over Ks- 150,000" +
                  "");
          coupons.setExpire("Expires 2017/08/27");
          couponsList.add(i,coupons);
        }

        
        adapter = new BottomSheetAdapter(getContext(), couponsList);
        rvDiscountCoupon.setAdapter(adapter);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.navigation_songs:
                        break;
                    case R.id.navigation_albums:
                        break;
                    case R.id.navigation_artists:
                        break;
                              }
                return true;
            }
        });
        return view;
    }
}
