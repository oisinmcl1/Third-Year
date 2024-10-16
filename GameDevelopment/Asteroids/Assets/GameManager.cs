using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameManager : MonoBehaviour
// Lab 5 starter code
{
    // inspector settings
    public GameObject asteroidPrefab, spaceshipPrefab, fragmentPrefab;

    // class-level statics
    public static GameManager instance;
    public static int currentGameLevel;
    public static Vector3 screenBottomLeft, screenTopRight;
    public static float screenWidth, screenHeight;
    
    // Use this for initialization
    void Start()
    {
        instance = this;
        Camera.main.transform.position = new Vector3(0f, 30f, 0f);
        Camera.main.transform.LookAt(Vector3.zero, new Vector3(0f, 0f, 1f));
        currentGameLevel = 0;
        StartNextLevel();
        CreatePlayerSpaceship();
    }

    public static void StartNextLevel()
    {
        currentGameLevel++;
        // find (slightly expanded) screen corners and size, in world coordinates
        // for ViewportToWorldPoint, the z value specified is in world units from the camera
        screenBottomLeft = Camera.main.ViewportToWorldPoint(new Vector3(-0.1f,-0.1f,30f)); 
        screenTopRight = Camera.main.ViewportToWorldPoint (new Vector3(1.1f,1.1f,30f)); 
        screenWidth = screenTopRight.x - screenBottomLeft.x;
        screenHeight = screenTopRight.z - screenBottomLeft.z;
        
        Debug.Log("BottomLeft: " + screenBottomLeft);
        Debug.Log("TopRight: " + screenTopRight);
        Debug.Log("Width: " + screenWidth);
        Debug.Log("Height: " + screenHeight);
        
        // instantiate some asteroids near the edges of the screen
        for (int i = 0; i < currentGameLevel * 2 + 3; i++)
        {
            GameObject go = Instantiate(instance.asteroidPrefab) as GameObject;
            float x, z;

            if (Random.Range(0f, 1f) < 0.5f)
            {
                x = screenBottomLeft.x + Random.Range(0f, 0.15f) * screenWidth;
            }
            else
            {
                x = screenTopRight.x - Random.Range(0f, 0.15f) * screenWidth;
            }

            if (Random.Range(0f, 1f) < 0.5f)
            {
                z = screenBottomLeft.z + Random.Range(0f, 0.15f) * screenHeight;
            }
            else
            {
                z = screenTopRight.z - Random.Range(0f, 0.15f) * screenHeight;
            }
            
            go.transform.position = new Vector3(x, 0f, z);
        }
    }
    public void CreatePlayerSpaceship()
    {
        GameObject go = Instantiate(instance.spaceshipPrefab);
        go.transform.position = Vector3.zero;
    }
}