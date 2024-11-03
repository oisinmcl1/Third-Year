using System;
using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;
using Random = UnityEngine.Random;

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
    
    // Game state
    public bool isPlaying;

    public GameObject menuCanvas;
    public GameObject playingCanvas;
    
    // For changing UI text
    public TMP_Text scoreText;
    public TMP_Text livesText;
    public TMP_Text highScoreText;
    
    // Game score and lives
    public int score;
    public int lives;
    public int highScore;

    // public int aCount;
    
    // Use this for initialization
    void Start()
    {
        // Set to menu UI when game starts
        isPlaying = false;
        UpdateUI();
    }

    public static void StartNextLevel()
    {
        currentGameLevel++;
        Debug.Log("Starting new level " + currentGameLevel);
        
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
        
        // Take count of asteroids
        // instance.aCount = currentGameLevel * 2;
        
        Debug.Log("Asteroid count: " + currentGameLevel * 2);
        
        // instantiate some asteroids near the edges of the screen
        for (int i = 0; i < currentGameLevel * 2; i++)
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
        Debug.Log("LIVES BEFORE SPACESHIP SPAWNS: " + lives);
        /*
         if (lives > 0)
        {
            Debug.Log("Creating new spaceship");
            GameObject go = Instantiate(instance.spaceshipPrefab);
            go.transform.position = Vector3.zero;
        }
        else
        {
            Debug.Log("No more lives");
        }
        */
        
        Debug.Log("Creating new spaceship"); 
        GameObject go = Instantiate(instance.spaceshipPrefab);
        go.transform.position = Vector3.zero;
    }

    public void StartNewGame()
    {
        instance = this;
        Camera.main.transform.position = new Vector3(0f, 30f, 0f);
        Camera.main.transform.LookAt(Vector3.zero, new Vector3(0f, 0f, 1f));
        currentGameLevel = 0;
        
        // Initialise score and lives
        score = 0;
        lives = 3;
        
        // Start game and create spaceship
        StartNextLevel();
        CreatePlayerSpaceship();
        
        // Set to playing UI when start game button is pressed
        isPlaying = true;
        UpdateUI();
        AddScore(0);
        livesText.text = "Lives: " + lives;
        highScoreText.text = "High Score: " + highScore;
    }

    public void UpdateUI()
    {
        // Update UI based on current game state
        if (isPlaying == false)
        {
            menuCanvas.SetActive(true);
            playingCanvas.SetActive(false);
        }
        else if (isPlaying == true)
        {
            menuCanvas.SetActive(false);
            playingCanvas.SetActive(true);
        }
    }

    public void AddScore(int points)
    {
        // Add points to score and call UpdateScoreUI
        score += points;
        UpdateScoreUI();
        
        // Check if current score is higher than high score
        HighScoreChecker(score);
    }
    public void UpdateScoreUI()
    {
        // Change the score in UI when it's changed
        scoreText.text = "Score: " + score;
    }

    public void HighScoreChecker(int score)
    {
        // Check if current score is higher than high score
        if (score > highScore)
        {
            highScore = score;
            highScoreText.text = "High Score: " + highScore;
        }
    }

    public void AsteroidCountCheck()
    {
        Debug.Log("aCount check func called in GameManager.cs");
        int asteroidCount = FindObjectsOfType<Asteroid>().Length;
        
        Debug.Log("Current count: " + asteroidCount);
        
        // Check if all asteroids are destroyed by seeing if there are no more asteroids in the scene
        if (asteroidCount == 0)
        {
            Debug.Log("All Asteroids Destroyed");
            StartNextLevel();
        }
    }

    public void ReduceLife()
    {
        // Reduce life by 1 when hit
        lives--;
        
        // Update UI
        livesText.text = "Lives: " + lives;
        
        // If no more lives, back to the menu buddy
        if (lives == 0)
        {
            isPlaying = false;
            UpdateUI();
            
            // Destroy all reamining asteroids
            GameObject[] asteroids = GameObject.FindGameObjectsWithTag("Asteroid");
            for (int i = 0; i < asteroids.Length; i++)
            {
                Destroy(asteroids[i]);
            }
            
            // Destroy spaceship
            GameObject spaceship = GameObject.FindGameObjectWithTag("Spaceship");
            Destroy(spaceship);
        }
    }
}