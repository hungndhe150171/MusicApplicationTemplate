package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.musicapplicationtemplate.R;

import java.io.File;
import java.util.List;

import model.Song;


public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    Context context;
    List<Song> songs;

    public SongAdapter(Context context, List<Song> songs) {
        this.context = context;
        this.songs = songs;
    }

    @NonNull
    @Override
    public SongAdapter.SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_song,parent,false);
         return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.SongViewHolder holder, int position) {
        holder.tvSongTitle.setText(songs.get(position).getTitle());
        holder.tvSongArtist.setText(songs.get(position).getArtist());

        int imageResourceId = context.getResources().getIdentifier(songs.get(position).getImage().split("\\.")[0], "drawable", context.getPackageName());
        Glide.with(context)
                .load(imageResourceId)
                .apply(new RequestOptions().placeholder(R.drawable.placecholder_image))
                .into(holder.ivSongImage);

//        String imageName = songs.get(position).getImage(); // ví dụ: "bau_troi_moi.jpg"
//        // Chuyển đổi tên file thành resource ID từ drawable
//        int resourceId = context.getResources().getIdentifier(imageName.split("\\.")[0], "drawable", context.getPackageName());
//        Glide.with(context)
//                .load(resourceId)  // sử dụng resource ID
//                .apply(new RequestOptions().placeholder(R.drawable.placecholder_image))
//                .into(holder.ivSongImage);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public static class SongViewHolder extends RecyclerView.ViewHolder {

        ImageView ivSongImage;
        TextView tvSongTitle;
        TextView tvSongArtist;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            ivSongImage = itemView.findViewById(R.id.ivSongImage);
            tvSongTitle = itemView.findViewById(R.id.tvSongTitle);
            tvSongArtist = itemView.findViewById(R.id.tvSongArtist);
        }
    }
}
