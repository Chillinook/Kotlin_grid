package com.example.practice03_grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice03_grid.data.Datasource
import com.example.practice03_grid.model.Topic
import com.example.practice03_grid.ui.theme.Practice03_gridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practice03_gridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationsApp()
                }
            }
        }
    }
}

@Composable
fun AffirmationsApp() {
    AffirmationsList( aff = Datasource().topics ) ;
}

@Composable
fun AffirmationsList( aff: List<Topic> ) {
    LazyColumn {
        items(aff){
                affir -> AffirmationsCard( affir );
        }
    }

}

@Composable
fun AffirmationsCard(aff: Topic ) {
    Card(
        modifier = Modifier
            .padding(20.dp)
    ){
        Image(
            painter = painterResource(id = aff.imageResourceId),
            contentDescription = stringResource(id = aff.stringId ),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = stringResource(id = aff.stringId ),
            textAlign = TextAlign.Center
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practice03_gridTheme {
        AffirmationsApp()
    }
}