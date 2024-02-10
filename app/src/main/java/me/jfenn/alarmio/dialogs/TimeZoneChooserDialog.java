package me.jfenn.alarmio.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;

import me.jfenn.alarmio.R;
import me.jfenn.alarmio.adapters.TimeZonesAdapter;


public class TimeZoneChooserDialog extends AestheticDialog {

    private final String[] excludedIds = new String[0];

    public TimeZoneChooserDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_time_zone_chooser);

        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        List<String> timeZones = new ArrayList<>();
        for (String id1 : TimeZone.getAvailableIDs()) {
            boolean isFine = true;
            for (String id2 : timeZones) {
                if (TimeZone.getTimeZone(id1).getRawOffset() == TimeZone.getTimeZone(id2).getRawOffset()) {
                    isFine = false;
                    break;
                }
            }

            for (String id2 : excludedIds) {
                if (TimeZone.getTimeZone(id1).getRawOffset() == TimeZone.getTimeZone(id2).getRawOffset()) {
                    isFine = false;
                    break;
                }
            }

            if (isFine)
                timeZones.add(id1);
        }

        timeZones.sort(Comparator.comparingInt(id -> TimeZone.getTimeZone(id).getRawOffset()));

        recycler.setAdapter(new TimeZonesAdapter(timeZones));

        findViewById(R.id.ok).setOnClickListener(v -> dismiss());
    }

    @Override
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null)
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }
}
