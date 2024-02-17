package com.example.practice03_grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
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
            .padding(3.dp)
            .clip( shape = RoundedCornerShape(
                topEnd = 16.dp,
                bottomEnd = 16.dp,
                topStart = 16.dp,
                bottomStart = 16.dp
            )
            )
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
            modifier = Modifier
                .background( color = Color(0xFFE2CEF0 ) )
        ){
            Row (
            ){
                Text(
                    fontSize = 12.sp,
                    text = stringResource(id = aff.stringId ),
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding( top = 16.dp , bottom = 8.dp , start = 16.dp , end = 16.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_grain),
                    contentDescription = null,
                    modifier = Modifier
                        .padding( start = 16.dp , end = 8.dp , bottom = 4.dp)
                )
                Text(
                    text = aff.num.toString(),
                    fontSize = 12.sp,
                )
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