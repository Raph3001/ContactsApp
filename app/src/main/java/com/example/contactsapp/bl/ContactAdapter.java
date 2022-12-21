package com.example.contactsapp.bl;

import android.content.Context;
import android.content.res.AssetManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsapp.R;
import com.example.contactsapp.pojos.Contact;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ContactAdapter extends RecyclerView.Adapter<ContactHolder> {
    private LayoutInflater inflater;
    public static List<Contact> contactList = new ArrayList<>();
    private Context context;
    public static List<Contact> removedList = new ArrayList<>();


    public ContactAdapter(Context context, String csvURL, String s) {
        AssetManager assetManager = context.getAssets();
        listingItems(assetManager, csvURL,s);
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    private void listingItems(AssetManager assetManager, String csvURL, String s) {
        try {
            InputStream is = assetManager.open(csvURL);
            contactList = new BufferedReader(new InputStreamReader(is)).lines()
                    .skip(1)
                    .map(Contact::new)
                    .filter(c -> c.getFirstName().toLowerCase(Locale.ROOT).contains(s) || c.getLastName().toLowerCase(Locale.ROOT).contains(s))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < removedList.size(); i++) {
            for (int j = 0; j<contactList.size(); j++) {
                if (removedList.get(i).getFirstName().equals(contactList.get(j).getFirstName())) {
                    contactList.remove(j);
                    break;
                }
            }
        }
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.contact, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        holder.setContext(context);
        Contact contact = contactList.get(position);
        holder.setContact(contact);
        Picasso.get()
                .load(contact.getPicture())
                .placeholder(R.drawable.img)
                .into(holder.getIvIcon());
        String string = contact.getFirstName() + " " + contact.getLastName();
        holder.getTvName().setText(string);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
