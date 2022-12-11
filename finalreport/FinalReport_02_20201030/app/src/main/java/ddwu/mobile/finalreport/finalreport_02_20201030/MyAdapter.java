package ddwu.mobile.finalreport.finalreport_02_20201030;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Music> musicList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, int layout, ArrayList<Music> musicList) {
        this.context = context;
        this.layout = layout;
        this.musicList = musicList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Object getItem(int i) {
        return musicList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return musicList.get(i).get_id();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int position = i;
        ViewHolder viewHolder;

        if(view == null) {
            view = layoutInflater.inflate(layout, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.textArtist = view.findViewById(R.id.vArtist);
            viewHolder.textTitle = view.findViewById(R.id.vTitle);
            viewHolder.textGenre = view.findViewById(R.id.vGenre);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.textArtist.setText(musicList.get(position).getArtist());
        viewHolder.textTitle.setText(musicList.get(position).getTitle());
        viewHolder.textGenre.setText(musicList.get(position).getGenre());

        return view;
    }

    static class ViewHolder {
        TextView textArtist;
        TextView textTitle;
        TextView textGenre;
    }
}
