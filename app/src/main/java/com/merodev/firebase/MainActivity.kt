package com.merodev.firebase


import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private  val db = FirebaseDatabase.getInstance().reference

    private lateinit var mr: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mr = db.child("users")
        btnEnviar.setOnClickListener {

            val user=Users(etNombre.text.toString(),etMail.text.toString(),etCargo.text.toString())

            mr.child(user.correo.toString()).setValue(user)

        }

         var userListener=object:ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for ( snap in dataSnapshot.getChildren()) {
                    var user=snap.getValue(Users::class.java)
                    Log.d("aqui",user?.correo)

                }




            }


        }
        mr.addValueEventListener(userListener)



    }









}



