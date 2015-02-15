package criminalintent.android.bignerdranch.com.criminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by samuel on 07/02/15.
 */
public class SelectTimeDialog extends DialogFragment {

    private static final String EXTRA_DATETIME = "extra_date_time";
    private static final String DIALOG_DATETIME = "dialog_date_time";
    private Date mDate;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_select_time_or_date, null);

        Button buttonTime = (Button)v.findViewById(R.id.time_button);
        Button buttonDate = (Button)v.findViewById(R.id.date_button);

        mDate = (Date) getArguments().get(EXTRA_DATETIME);

        buttonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                TimePickerFragment timePickerFragment = TimePickerFragment.newInstance(mDate);
                timePickerFragment.setTargetFragment(SelectTimeDialog.this.getTargetFragment(), CrimeFragment.REQUEST_DATETIME);
                timePickerFragment.show(fm, DIALOG_DATETIME);
                SelectTimeDialog.this.dismiss();
            }
        });

        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                DatePickerFragment datePickerFragment = DatePickerFragment.newInstance(mDate);
                datePickerFragment.setTargetFragment(SelectTimeDialog.this.getTargetFragment(), CrimeFragment.REQUEST_DATETIME);
                datePickerFragment.show(fm, DIALOG_DATETIME);
                SelectTimeDialog.this.dismiss();
            }
        });

        return new AlertDialog.Builder(getActivity()).setTitle(R.string.time_picker_title).setView(v)
                .create();
    }

    private void initTimePicker(TimePicker timePicker, int hour, int minute, int second) {
        timePicker.setCurrentHour(hour);
        timePicker.setIs24HourView(true);
        timePicker.setCurrentMinute(minute);
    }

    public static SelectTimeDialog newInstance(Date date) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_DATETIME, date);
        SelectTimeDialog fragment = new SelectTimeDialog();
        fragment.setArguments(args);
        return fragment;
    }
}
