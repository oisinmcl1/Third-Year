using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Spaceship : MonoBehaviour
// Lab 5 starter code
{
    private Rigidbody rigid;
    void Start()
    {
        rigid = GetComponent<Rigidbody>();
    }

    void FixedUpdate()
    {
        if (Input.GetKey(KeyCode.UpArrow))
        {
            rigid.AddForce(transform.forward * (rigid.mass * Time.fixedDeltaTime * 1000f));
        }

        // we're using an Angular Drag of 15.0 on the rigid body, so need a lot of torque here
        if (Input.GetKey(KeyCode.LeftArrow))
        {
            rigid.AddTorque(-Vector3.up * (rigid.mass * Time.fixedDeltaTime * 4000f));
        }
        else if (Input.GetKey(KeyCode.RightArrow))
        {
            rigid.AddTorque(Vector3.up * (rigid.mass * Time.fixedDeltaTime * 4000f));
        }
    }
}