package my.tutorial.tutorial4part2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;


public class CustomAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public CustomAdapter(Context context, String[] v) {
        super(context, R.layout.rowlayout, v);
        this.context = context;
        this.values = v;
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);

        TextView textView = rowView.findViewById(R.id.label);
        ImageView imageView = rowView.findViewById(R.id.icon);
        textView.setText(values[position]);
        // Change the icon for Windows and iPhone
        String s = values[position];
        if (s.startsWith("Seafood") || s.startsWith("Supreme")) {
            imageView.setImageResource(R.drawable.image4);
        }
        else {
            imageView.setImageResource(R.drawable.image5);
        }

        return rowView;
    }
}