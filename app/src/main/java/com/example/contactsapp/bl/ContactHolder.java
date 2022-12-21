package com.example.contactsapp.bl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsapp.MainActivity;
import com.example.contactsapp.R;
import com.example.contactsapp.openContact;
import com.example.contactsapp.pojos.Contact;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class ContactHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView tvName;
    private ImageView ivIcon;
    private Context context;
    private Contact contact;
    private GestureDetectorCompat gestureDetectorCompat;

    @SuppressLint("ClickableViewAccessibility")
    public ContactHolder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tvName);
        ivIcon = itemView.findViewById(R.id.ivAvatar);
        itemView.setOnClickListener(this);

        MyGestureListener myGestureListener = new MyGestureListener();
        gestureDetectorCompat = new GestureDetectorCompat(context, myGestureListener);

        itemView.setOnTouchListener((view, motionEvent) -> {
            if(!gestureDetectorCompat.onTouchEvent(motionEvent)) {
                return false;
            }
            else {
                List<Contact> contactList = ContactAdapter.contactList;
                Contact contact = null;
                for (int i = 0; i < contactList.size(); i++) {
                    System.out.println(getContact().getFirstName());
                    if (getContact().getFirstName().equals(contactList.get(i).getFirstName())) {
                        contact = contactList.get(i);
                    }
                }
                ContactAdapter.removedList.add(contact);
                MainActivity.rv.setAdapter(new ContactAdapter(context, "contact_data.csv", ""));
            }
            return true;
        });


    }

    public void setContext(Context context) {
        this.context = context;
    }

    public TextView getTvName() {
        return tvName;
    }

    public void setTvName(TextView tvName) {
        this.tvName = tvName;
    }

    public ImageView getIvIcon() {
        return ivIcon;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, openContact.class);
        intent.putExtra("fname", contact.getFirstName());
        intent.putExtra("lname", contact.getLastName());
        intent.putExtra("phone", contact.getPhoneNumber());
        intent.putExtra("gender", contact.getGender());
        intent.putExtra("lang", contact.getLanguage());
        intent.putExtra("image", contact.getPicture() + "");
        context.startActivity(intent);
    }

}
