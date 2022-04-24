package com.midterm.totalbill

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.midterm.totalbill.ui.theme.TotalBillTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TotalBillTheme {

                val summ = remember {mutableStateOf("") }
                val count =remember {mutableStateOf(1) }
                val inputvalue = remember { mutableStateOf(TextFieldValue()) }
                val sliderPosition = remember { mutableStateOf(0f)}
                val intPosition = (sliderPosition.value * 100).roundToInt()
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    color = MaterialTheme.colors.background
                ) {

                    Card(
                        modifier = Modifier
                            .width(200.dp)
                            .height(390.dp)
                            .padding(2.dp),
                        elevation = 4.dp

                    ) {
                        Column(
                            modifier = Modifier.height(300.dp),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CreateInfo(inputvalue.value.text, count.value, intPosition )
                            TextField(
                                value = inputvalue.value,

                                onValueChange = { inputvalue.value = it },

                                placeholder = { Text(text = "Enter Bill") },


                                )

                            Divider()
                            if (inputvalue.value.text !="")
                            {
                                Card(modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp)
                                    .height(200.dp),
                                    shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                                )
                                {
                                    Column(modifier = Modifier
                                        .padding(0.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center

                                    )
                                    {
                                        Row() {
                                            Text(text = "Split", modifier = Modifier.padding(0.dp, 0.dp, 100.dp, 5.dp))


                                            CreateButtonInc(count = count.value){
                                                    newValue->count.value = newValue
                                            }

                                            Text(text =  "${count.value}",modifier = Modifier.padding(5.dp, 5.dp, 5.dp, 5.dp))


                                            CreateButtonDec(count = count.value){
                                                    newValue->count.value = newValue
                                            }

                                        }
                                        Row() {
                                            Text(text = "Tip", modifier = Modifier.padding(0.dp, 0.dp, 150.dp, 5.dp))




                                            Text(text =  "$intPosition"+" %",modifier = Modifier.padding(5.dp, 5.dp, 5.dp, 5.dp))




                                        }
                                        Text(
                                                "$intPosition"+" %",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 25.sp
                                        )

                                        Slider(
                                            value = sliderPosition.value,
                                            onValueChange = { sliderPosition.value = it
                                            }
                                        )



                                    }
                                }
                            }
                        }


                    }
                }
            }
        }
    }
}


@Composable
fun CreateInfo(summ: String, count: Int, tip : Int){
    var rel = ""
if (summ !="")
{
//    rel = ( summ.toInt()*tip/ (count)  ).toString()
      val total = summ.toInt()*(100+tip)/(count * 100)
    rel =total.toString()

}
    Card(modifier = Modifier
        .padding(20.dp)
        .fillMaxWidth()
        .padding(5.dp)
        .height(150.dp),
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        backgroundColor= MaterialTheme.colors.primary)
    {
        Column(modifier = Modifier
            .padding(3.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        )
        {
            Text(text = "Total Per Person",
                style = MaterialTheme.typography.h4,
                color = Color.Black

            )
            Row() {
                Text(text = "$",
                    style = MaterialTheme.typography.h4,
                    color = Color.Black


                )
                Text(text =rel ,
                    
                    style = MaterialTheme.typography.h4,
                    color = Color.Black


                )
            }

        }
    }
}


@Composable
fun CreateButtonInc(count: Int=0, countUp: (Int) -> Unit)
{
    Card(modifier= Modifier
        .size(30.dp)
        .padding(5.dp)
        .clickable { countUp(count + 1 )},
        shape = CircleShape,
        border= BorderStroke(1.dp, Color.Blue))

     {
        Icon(Icons.Default.Add, contentDescription = "content description")
    }
}
@Composable
fun CreateButtonDec(count: Int=0, countDown: (Int) -> Unit)
{
    Card(modifier= Modifier
        .size(30.dp)
        .padding(5.dp)
        .clickable { countDown(count - 1 )},
        shape = CircleShape,
        border= BorderStroke(1.dp, Color.Blue))

    {
        Icon(Icons.Default.Remove, contentDescription = "content description")
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TotalBillTheme {
        Greeting("Android")
    }
}