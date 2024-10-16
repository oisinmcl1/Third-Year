using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Spaceship : MonoBehaviour
// Lab 5 starter code
{
    private Rigidbody rigid;
    // public static int bulletCount = 0;
    // public float nextFire = 0f;
    private bool canFire = true;
    
    public GameObject bulletPrefab;
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
        
        // Instantiate bullet when space key is pressed
        if (Input.GetKey(KeyCode.Space) && canFire)
        {
            StartCoroutine(fireBullet());
        }
    }
    IEnumerator fireBullet()
    {
        // Wait for 0.25 seconds before firing bullet again (4 a second)
        canFire = false;
        yield return new WaitForSeconds(0.25f);
        
        // Debug.Log("Bullet instantiated");
        
        // Instantiate bullet infront of spaceship with same rotation as well
        Instantiate(bulletPrefab, transform.position + transform.forward * 1.5f, transform.rotation);

        // Give bullet velocity in the direction it is facing
        // Rigidbody bRb = bulletPrefab.GetComponent<Rigidbody>();
        // bRb.velocity = transform.forward * 10f;

        // bulletCount++;
        canFire = true;
    }
}