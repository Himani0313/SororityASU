package com.example.himanishah.udemyadvancedcourse.views.AboutUsViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.himanishah.udemyadvancedcourse.R;
import com.example.himanishah.udemyadvancedcourse.activities.BaseActivity;
import com.example.himanishah.udemyadvancedcourse.entities.EventCard;

import java.util.ArrayList;

/**
 * Created by himanishah on 8/25/17.
 */

public class AboutUsAdapter extends RecyclerView.Adapter {


    //>>Header<//

    //>>List Header<//
    //>>CommunityService list<<//

    //>>List Header<//
    //>>SisterHood list<<//

    //>>List Header<//
    //>>Social list<<//

    private final int VIEW_TYPE_MAIN_HEADER = 1;
    private final int VIEW_TYPE_SERVICE_LIST = 2;
    private final int VIEW_TYPE_SISTERHOOD_LIST = 3;
    private final int VIEW_TYPE_SOCIAL_LIST = 4;
    private final int VIEW_TYPE_LIST_HEADER = 5;

    private LayoutInflater inflater;
    private BaseActivity activity;
    private ArrayList<EventCard> communityServiceEventCards;
    private ArrayList<EventCard> sisterHoodEventCards;
    private ArrayList<EventCard> socialEventCards;

    private aboutUsListener listener;

    public AboutUsAdapter(BaseActivity activity, aboutUsListener listener) {
        this.activity = activity;
        this.listener = listener;
        inflater = activity.getLayoutInflater();
        communityServiceEventCards = new ArrayList<>();
        sisterHoodEventCards = new ArrayList<>();
        socialEventCards = new ArrayList<>();
    }


    public ArrayList<EventCard> getCommunityServiceEventCards() {
        return communityServiceEventCards;
    }

    public ArrayList<EventCard> getSisterHoodEventCards() {
        return sisterHoodEventCards;
    }

    public ArrayList<EventCard> getSocialEventCards() {

        return socialEventCards;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View eventCardView = inflater.inflate(R.layout.list_event_card,parent,false);
        final View listHeader = inflater.inflate(R.layout.simple_header,parent,false);
        if(viewType == VIEW_TYPE_MAIN_HEADER){
            return new AboutUsMainHeaderViewHolder(inflater,parent);
        }
        else if(viewType == VIEW_TYPE_SERVICE_LIST){
            final CommunityServiceViewHolder communityServiceViewHolder = new CommunityServiceViewHolder(eventCardView);
            communityServiceViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventCard eventCard = (EventCard) communityServiceViewHolder.itemView.getTag();
                    listener.OnEventCardClicked(eventCard);
                }
            });
            return communityServiceViewHolder;
        }

        else if( viewType == VIEW_TYPE_SISTERHOOD_LIST){
            final SisterHoodViewHolder sisterHoodViewHolder = new SisterHoodViewHolder(eventCardView);
            sisterHoodViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventCard eventCard = (EventCard) sisterHoodViewHolder.itemView.getTag();
                    listener.OnEventCardClicked(eventCard);
                }
            });
            return sisterHoodViewHolder;
        }

        else if(viewType == VIEW_TYPE_SOCIAL_LIST){
            final SocialViewHolder socialViewHolder = new SocialViewHolder(eventCardView);
            socialViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventCard eventCard = (EventCard) socialViewHolder.itemView.getTag();
                    listener.OnEventCardClicked(eventCard);
                }
            });
            return socialViewHolder;
        }

        else if(viewType == VIEW_TYPE_LIST_HEADER){
            return new AboutUsListHeaderViewHolder(listHeader);
        }
        throw new IllegalArgumentException(viewType + "is not supported in this adapter");

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof AboutUsMainHeaderViewHolder){
            AboutUsMainHeaderViewHolder holder1 = (AboutUsMainHeaderViewHolder) holder;

        }
        if(holder instanceof CommunityServiceViewHolder){
            position--;
            if (communityServiceEventCards.size()>0){
                position--;
            }
            EventCard eventCard = communityServiceEventCards.get(position);
            ((CommunityServiceViewHolder)holder).populate(activity, eventCard);

        }
        if(holder instanceof SisterHoodViewHolder){
            position--;
            if(communityServiceEventCards.size()>0){
                position--;
                position -= communityServiceEventCards.size();
            }
            if (sisterHoodEventCards.size()>0){
                position--;
            }
            EventCard eventCard = sisterHoodEventCards.get(position);
            ((SisterHoodViewHolder)holder).populate(activity, eventCard);
        }

        if(holder instanceof SocialViewHolder){
            position--;
            if(communityServiceEventCards.size()>0){
                position--;
                position -= communityServiceEventCards.size();
            }
            if (sisterHoodEventCards.size()>0){
                position--;
                position -= sisterHoodEventCards.size();
            }
            if (socialEventCards.size()>0){
                position--;
            }
            EventCard eventCard = socialEventCards.get(position);
            ((SocialViewHolder)holder).populate(activity, eventCard);
        }

        if(holder instanceof AboutUsListHeaderViewHolder){
            AboutUsListHeaderViewHolder aboutUsListHeaderViewHolder = (AboutUsListHeaderViewHolder) holder;

            int servicePosition = 1;
            int sisterhoodPosition = servicePosition + communityServiceEventCards.size() + 1;
            int socialPosition = sisterhoodPosition + sisterHoodEventCards.size() + 1;

            if (position == servicePosition){
                aboutUsListHeaderViewHolder.populate("Community Service Events");
            }
            if (position == sisterhoodPosition){
                aboutUsListHeaderViewHolder.populate("SisterHood Events");
            }
            if(position == socialPosition){
                aboutUsListHeaderViewHolder.populate("Social Events");
            }
        }
    }

    @Override
    public int getItemCount() {
        int count = 1;
        if (communityServiceEventCards.size()>0){
            count += 1 + communityServiceEventCards.size();
        }
        if (sisterHoodEventCards.size()>0){
            count += 1 + sisterHoodEventCards.size();
        }
        if (socialEventCards.size()>0){
            count += 1 + socialEventCards.size();
        }
        return count;
    }

    public interface aboutUsListener{
        public void OnEventCardClicked(EventCard eventCard);
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return VIEW_TYPE_MAIN_HEADER;
        }
        position--;
        if(communityServiceEventCards.size()>0){
            if (position == 0){
                return VIEW_TYPE_LIST_HEADER;
            }
            position--;
            if(position<communityServiceEventCards.size()){
                return VIEW_TYPE_SERVICE_LIST;
            }
            position -= communityServiceEventCards.size();
        }
        if(sisterHoodEventCards.size()>0){
            if (position == 0){
                return VIEW_TYPE_LIST_HEADER;
            }
            position--;
            if(position<sisterHoodEventCards.size()){
                return VIEW_TYPE_SISTERHOOD_LIST;
            }
            position -= sisterHoodEventCards.size();
        }
        if(socialEventCards.size()>0){
            if (position == 0){
                return VIEW_TYPE_LIST_HEADER;
            }
            position--;

        }
        if(position<socialEventCards.size()){
            return VIEW_TYPE_SOCIAL_LIST;
        }
        position -= socialEventCards.size();

        throw new IllegalArgumentException("We are being asked for a viewType for a position" + position +"although"+
        "we are at the end of the adapter supportviewholders. Please Check your adapter");
    }
}
