package info.androidhive.bottomsheet;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by MIT on 3/13/2018.
 */

public class BottomSheetAdapter extends RecyclerView.Adapter<BottomSheetAdapter.BottomSheetViewHolder> {

    private Context context;
    private List<Coupons> couponsList;

    public BottomSheetAdapter(Context context, List<Coupons> couponsList) {
        this.context = context;
        this.couponsList = couponsList;
    }

    @NonNull
    @Override
    public BottomSheetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.coupon_row_item, parent, false);

        return new BottomSheetViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BottomSheetViewHolder holder, int position) {

        holder.bind(couponsList.get(position));
    }

    @Override
    public int getItemCount() {
        return couponsList.size();
    }

    public class BottomSheetViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tv_name)
        TextView tvName;

        @BindView(R.id.tv_amount)
        TextView tvAmount;

        @BindView(R.id.tv_description)
        TextView tvDescription;

        @BindView(R.id.tv_expire)
        TextView tvExpire;
        @BindView(R.id.btn_get_now)
        Button btn_get_it_now;

        public BottomSheetViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bind(Coupons coupons) {
            tvName.setText(coupons.getName());
            tvAmount.setText(coupons.getAmount());
            tvDescription.setText(coupons.getDescription());
            tvExpire.setText(coupons.getExpire());
        }
    }
}
