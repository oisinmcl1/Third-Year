using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameManager : MonoBehaviour
{
    private int currentGameLevel;
    public GameObject asteroid;
    
    // Start is called before the first frame update
    void Start()
    {
        // Set camera position to look down on the game
        Camera.main.transform.position = new Vector3(0, 30, 0);
        Camera.main.transform.LookAt(new Vector3(0, 0, 0), Vector3.forward);
        
        // Initialize game level
        currentGameLevel = 1;
        StartNextLevel();
    }

    // Update is called once per frame
    void Update()
    {
        /*
         if (Random.Range(0f, 100f) < 0.2f) {
            StartNextLevel();
            currentGameLevel++;
        }
        */
    }

    void StartNextLevel()
    {
        // Get the screen bounds using the main camera
        Vector3 bottomLeft = Camera.main.ViewportToWorldPoint(new Vector3(0, 0, Camera.main.transform.position.y));
        Vector3 topRight = Camera.main.ViewportToWorldPoint(new Vector3(1, 1, Camera.main.transform.position.y));
        
        // Number of asteroid spawns doubles each level
        for (int i = 0; i < currentGameLevel * 2; i++)
        {
            // Randomize asteroid spawn position
            Vector3 spawnPos = new Vector3(Random.Range(-15, 15), 0, Random.Range(-15, 15));
            
            // Instantiate asteroid at spawn position with no rotation
            Instantiate(asteroid, spawnPos, Quaternion.identity);
        }
    }
}
