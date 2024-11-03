using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Asteroid : MonoBehaviour
// Lab 5 starter code
{
    public Rigidbody rigidBody;
    public bool largeAsteroid;
    
    void Start()
    {
        // randomise size+mass
        transform.localScale = new Vector3(Random.Range(0.08f, 0.12f), Random.Range(0.08f, 0.12f), Random.Range(0.08f, 0.12f));
        rigidBody.mass = transform.localScale.x * transform.localScale.y * transform.localScale.z;
        // randomise velocity
        rigidBody.velocity = new Vector3(Random.Range(-10f, 10f), 0f, Random.Range(-10f, 10f));
        rigidBody.angularVelocity = new Vector3(Random.Range(-4f, 4f), Random.Range(-4f, 4f), Random.Range(-4f, 4f));

        largeAsteroid = true;
    }

    
    private void OnCollisionEnter(Collision collision) {
        Debug.Log("Collision with " + collision.gameObject.name);
        
        float colSpeed = collision.relativeVelocity.magnitude;
        int num = Mathf.Clamp( Mathf.RoundToInt(colSpeed), 2, 8);
        
        for (int i=0; i<num; i++) {
            Debug.Log("Fragment spawned " + i);
            GameObject go = Instantiate(GameManager.instance.fragmentPrefab); 
            go.transform.position = collision.contacts[0].point;
            Rigidbody r = go.GetComponent<Rigidbody>();
            r.velocity = new Vector3 (Random.Range (-colSpeed, colSpeed), 0f, Random.Range (-colSpeed, colSpeed));
            r.angularVelocity = new Vector3 (Random.Range (-4f, 4f), Random.Range (-4f, 4f), Random.Range (-4f, 4f)); 
        }
        
        // Add collision detection for spaceship
        if (collision.gameObject.CompareTag("Spaceship"))
        {
            // Destroy asteroid and respawn spaceship in gamemanager
            Debug.Log("Spaceship hit asteroid");
            Destroy(collision.gameObject);
            GameManager.instance.CreatePlayerSpaceship();
            Destroy(gameObject);
            
            // Reduce lives when hit
            GameManager.instance.ReduceLife();
        }
        
        // Call AsteroidCountCheck function in GameManager
        GameManager.instance.AsteroidCountCheck();
    }

    // Since bullet is a trigger, need to use OnTriggerEnter
    void OnTriggerEnter(Collider other)
    {
        // Add collision detection for bullet
        if (other.gameObject.CompareTag("Bullet"))
        {
            // Destroy bullet and asteroid
            Debug.Log("Destroyed Asteroid (why won't this work)");
            Destroy(other.gameObject);
            Destroy(gameObject);
            
            // If large asteroid, spawn small asteroid prefabs
            if (largeAsteroid)
            {
                smallAsteroidsSpawn();
                
                // If large asteroid destroyed, add 5 points to score
                GameManager.instance.AddScore(5);
            }
            else
            {
                // If small asteroid destroyed, add 10 points to score
                GameManager.instance.AddScore(10);
            }
            
            // Call AsteroidCountCheck function in GameManager
            Debug.Log("Calling aCountCheck from Asteroid.cs");
            GameManager.instance.AsteroidCountCheck();
        }
    }

    void smallAsteroidsSpawn()
    {
        // Small asteroid prefabs spawn
        for (int i = 0; i < 2; i++)
        {
            // Instantiate small asteroid and scale it down by half
            GameObject smallAsteroid = Instantiate(gameObject, transform.position + new Vector3((Random.Range(1,3)), 0, (Random.Range(1, 3))), transform.rotation);
            smallAsteroid.transform.localScale = transform.localScale / 2;
            
            // Set largeAsteroid bool to false
            smallAsteroid.GetComponent<Asteroid>().largeAsteroid = false;
            
            // Add velocity to small asteroid in random direction
            smallAsteroid.GetComponent<Rigidbody>().velocity = new Vector3(Random.Range(-10f, 10f), 0f, Random.Range(-10f, 10f));
            
            // Ensure it has Asteroid tag as well
            smallAsteroid.tag = "Asteroid";
            
            // I honestly didn't realise they didn't wrap screen so
            smallAsteroid.AddComponent<ScreenEdgeChecker>();
        }
    }
}