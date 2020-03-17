package browser.green.org.listviewpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseAdapter {

    List<Map<String, Object>> list;
    LayoutInflater inflater;

    public MyAdapter(Context context){
        this.inflater = LayoutInflater.from(context);
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        View view=null;
        if(convertView == null) {
            view = inflater.inflate(R.layout.item, null);
            holder = new ViewHolder();
            holder.avatar = view.findViewById(R.id.iv_item);
            holder.studentNum = view.findViewById(R.id.tv_list_item);
            view.setTag(holder);
        } else {
            view=convertView;
            holder = (ViewHolder) convertView.getTag();
        }
        System.out.println("position:"+position);
        System.out.println("convertView:"+convertView);

        Map map = list.get(position);
        holder.avatar.setImageResource((Integer) map.get("avatar"));
        holder.studentNum.setText((String)map.get("studentNum"));
        return view;
    }

    public static class ViewHolder {
        ImageView avatar;
        TextView studentNum;

    }
}
