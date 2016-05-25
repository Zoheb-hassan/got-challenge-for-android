package es.npatarino.android.gotchallenge.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collection;
import java.util.List;

import es.npatarino.android.gotchallenge.DetailActivity;
import es.npatarino.android.gotchallenge.model.GoTCharacter;
import es.npatarino.android.gotchallenge.R;
import es.npatarino.android.gotchallenge.utility.Constants;

/**
 * Created by ZohebS on 20-05-2016.
 */
public class GoTAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<GoTCharacter> goTCharacterList;
    private Activity activity;
    GoTCharacter goTCharacter;

    public GoTAdapter(Activity activity, List<GoTCharacter> goTCharacterList) {
        this.goTCharacterList = goTCharacterList;
        this.activity = activity;
    }

    void addAll(Collection<GoTCharacter> collection) {
        for (int i = 0; i < collection.size(); i++) {
            goTCharacterList.add((GoTCharacter) collection.toArray()[i]);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GotCharacterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.got_character_row, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        GotCharacterViewHolder gotCharacterViewHolder = (GotCharacterViewHolder) holder;
        goTCharacter = goTCharacterList.get(position);
        gotCharacterViewHolder.characterTextView.setText(goTCharacter.getCharacterName());
        Picasso.with(activity).load(goTCharacter.getCharacterPosterPath()).centerInside().into(gotCharacterViewHolder.characterImageView);
        gotCharacterViewHolder.characterImageView.setAdjustViewBounds(true);

    }

    @Override
    public int getItemCount() {
        return goTCharacterList.size();
    }

    class GotCharacterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private static final String TAG = "GotCharacterViewHolder";
        ImageView characterImageView;
        TextView characterTextView;

        public GotCharacterViewHolder(View itemView) {
            super(itemView);
            characterImageView = (ImageView) itemView.findViewById(R.id.ivBackground);
            characterTextView = (TextView) itemView.findViewById(R.id.tv_name);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();

            Intent intent = new Intent(this.itemView.getContext(), DetailActivity.class);
            intent.putExtra(Constants.CHARACTER_DESCRIPTION, goTCharacterList.get(position).getDescription());
            intent.putExtra(Constants.CHARACTER_NAME, goTCharacterList.get(position).getCharacterName());
            intent.putExtra(Constants.CHARACTER_POSTER_PATH, goTCharacterList.get(position).getCharacterPosterPath());
            this.itemView.getContext().startActivity(intent);


        }
    }

}
