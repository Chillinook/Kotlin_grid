package com.example.practice03_grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    GridApp()
                }
            }
        }
    }
}

@Composable
fun GridApp() {
    GridDataList( aff = Datasource().topics ) ;
}

@Composable
fun GridDataList( aff: List<Topic> ) {
//    LazyColumn {
//        items(aff){
//                affir -> GridItem( affir );
//        }
//    }
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2)
    ) {
        items (aff) {
            item -> GridItem(item)
        }
    }

}

@Composable
fun GridItem(aff: Topic ) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .background(color = Color.LightGray)
    ){
        Column {
            Image(
                painter = painterResource(id = aff.imageResourceId),
                contentDescription = null ,
                modifier = Modifier
                    .size( width = 68.dp, height = 68.dp)
            )

        }
        Column (

        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding( top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
            ){
                Text(

                    fontSize = 12.sp,
                    text = stringResource(id = aff.stringId ),
                    textAlign = TextAlign.Center
                )
            }
            Row {

            }

        }
    }



}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practice03_gridTheme {
        GridApp()
    }
}