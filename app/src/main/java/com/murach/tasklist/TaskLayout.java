package com.murach.tasklist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TaskLayout extends RelativeLayout implements OnClickListener {

    private CheckBox completedCheckBox;
    private TextView nameTextView;
    private TextView notesTextView;
    private RatingBar listViewRatingBar;

    private Task task;
    private TaskListDB db;
    private Context context;
    
    public TaskLayout(Context context) {   // used by Android tools
        super(context);
    }

    public TaskLayout(Context context, Task t) {
        super(context);
        
        // set context and get db object
        this.context = context;
        db = new TaskListDB(context);

        // inflate the layout
        LayoutInflater inflater = (LayoutInflater) 
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.listview_task, this, true);
        
        // get references to widgets
        //completedCheckBox = (CheckBox) findViewById(R.id.completedCheckBox);
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        notesTextView = (TextView) findViewById(R.id.notesTextView);
        listViewRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        
        // set listeners
        //completedCheckBox.setOnClickListener(this);
        this.setOnClickListener(this);

        // set task data on widgets
        setTask(t);
    }

    public void setTask(Task t) {
        task = t;
        nameTextView.setText(task.getNameOfMovie());
        
        // Remove the notes if empty
        if (task.getStringRating().equalsIgnoreCase("")) {
            notesTextView.setVisibility(GONE);
        }
        else {
            notesTextView.setText(task.getDateSeen());
            String stringRating = task.getStringRating();
            float floatRating = Float.parseFloat(stringRating);
            listViewRatingBar.setRating(floatRating);
        }

        /*
        if (task.getCompletedDateMillis() > 0){
            //completedCheckBox.setChecked(true);
        }
        */

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*case R.id.completedCheckBox:
                if (completedCheckBox.isChecked()){
                    task.setDateSeen(System.currentTimeMillis());
                }
                else {
                    task.setDateSeen(0);
                }
                db.updateTask(task);

                break;
                */
            default:
                Intent intent = new Intent(context, AddEditActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("taskId", task.getId());
                intent.putExtra("editMode", true);
                context.startActivity(intent);
                break;
            }
    }
}