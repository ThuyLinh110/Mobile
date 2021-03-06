package com.example.contactapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.example.contactapp.databinding.ActivityDetailBinding;

import java.io.IOException;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;
    private AppDatabase appDatabase;
    private ContactDao contactDao;
    private int id;
    ActivityResultLauncher<Intent> updateLauncher;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btn_edit:
                Intent intent = new Intent(DetailActivity.this, UpdateActivity.class);
                intent.putExtra("id", id);
                updateLauncher.launch(intent);
                break;
            case R.id.btn_delete:
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("Xóa liên hệ");
                dialog.setMessage("Bạn có muốn xóa liên hệ này không?");
                dialog.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Contact contact = contactDao.findById(id);
                        contactDao.delete(contact);
                        Intent intent = new Intent();
                        setResult(2, intent);
                        finish();
                    }
                });
                dialog.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                break;
            case R.id.btn_mark:
                break;
            default:
                NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        appDatabase = AppDatabase.getInstance(this);
        contactDao = appDatabase.contactDao();

        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getIntExtra("id", -1);
        }
        Contact contact = contactDao.findById(id);
        if (contact.getAvatar() != null) {
            binding.imgAvatar.setImageBitmap(BitmapHelper.byteArrayToBitmap(contact.getAvatar()));
        }
        binding.tvName.setText((contact.getLastName() + " " + contact.getFirstName()).trim());
        binding.tvPhone.setText(contact.getMobile());
        if (contact.getEmail().isEmpty()) {
            binding.llEmail.setVisibility(View.GONE);
        } else {
            binding.tvEmail.setText(contact.getEmail());
        }

        updateLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            String uri = data.getStringExtra("avatar");
                            byte[] avatar = null;
                            if (uri.equals("") == false) {
                                binding.imgAvatar.setImageURI(Uri.parse(uri));
                                Bitmap bitmap = null;
                                try {
                                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.parse(uri));

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                avatar = BitmapHelper.bitmapToByteArray(bitmap);
                            }
                            String firstName = data.getStringExtra("firstName");
                            String lastName = data.getStringExtra("lastName");
                            String phone = data.getStringExtra("phone");
                            String email = data.getStringExtra("email");
                            contactDao.update(id, avatar, firstName, lastName, phone, email, contactDao.findById(id).isMark());

                            binding.tvName.setText(lastName + " " + firstName);
                            binding.tvPhone.setText(phone);
                            if (email.isEmpty()) {
                                binding.llEmail.setVisibility(View.GONE);
                            } else {
                                binding.llEmail.setVisibility(View.VISIBLE);
                                binding.tvEmail.setText(email);
                            }
                            Toast.makeText(getApplicationContext(), "Chỉnh sửa liên hệ thành công!!", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}