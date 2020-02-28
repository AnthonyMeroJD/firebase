package com.merodev.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.*


import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

private  val db = FirebaseDatabase.getInstance()
    private var userListener: ValueEventListener? = null
    private lateinit var mr: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mr = FirebaseDatabase.getInstance().reference
            .child("users")
        btnEnviar.setOnClickListener {
            //hacer referencia a la base de datos


            //hacer referencia a la colleccion a la que quiero hacer referencia



            val user=Users(etNombre.text.toString(),etMail.text.toString(),etCargo.text.toString())

            mr.child(user.correo).setValue(user)

        }



    }

    override fun onStart() {
        super.onStart()
        val userListener=object :ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(Class<Users()>Users())
                value?.let {

                    tvcargo.text=it.cargo
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("s", "Failed to read value.", error.toException())
            }
        }
        mr.addValueEventListener(userListener)
        this.userListener=userListener


    }





}



