package io.github.aungkothet.padc.padc_adapterbasedview.akt.views.holders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.R;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.data.vos.EventV0;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.delegates.EventItemDelegate;

public class EventItemViewHolder extends BaseViewHolder<EventV0>{

    @BindView(R.id.textView)
    org.mmtextview.components.MMTextView event_name;

    @BindView(R.id.textView2)
    org.mmtextview.components.MMTextView textView2;

    @BindView(R.id.imageView)
    ImageView imageView;

    @BindView(R.id.img_gender)
    ImageView img_gender;

    @BindView(R.id.tv_age_range)
    org.mmtextview.components.MMTextView tv_age_range;

    @BindView(R.id.tv_location)
    org.mmtextview.components.MMTextView tv_location;

    @BindView(R.id.tv_location_detail)
    org.mmtextview.components.MMTextView tv_location_detail;

    @BindView(R.id.imageView3)
    ImageView imgOrganizerPhoto;

    @BindView(R.id.tv_name)
    org.mmtextview.components.MMTextView tv_name;

    @BindView(R.id.tv_role)
    org.mmtextview.components.MMTextView tv_role;

    private EventItemDelegate mEventItemDelegate;

    private Context context;
    public EventItemViewHolder(@NonNull View itemView,EventItemDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        context = itemView.getContext();

        mEventItemDelegate = delegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEventItemDelegate.onTapEventItem();
            }
        });
    }

    @Override
    public void bindData(EventV0 mData) {
        event_name.setText(mData.getEventName());
        tv_location_detail.setText(mData.getEventLocationFullAddress());
        tv_location.setText(mData.getEventLocationName());
        tv_name.setText(mData.getEventOrganizer().getOrganizerName());
        tv_role.setText(mData.getEventOrganizer().getOrganizerRole());

        Glide.with(context).load(mData.getEventOrganizer().getOrganizerPhotoUrl()).into(imgOrganizerPhoto);

    }
}
