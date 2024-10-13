@file:Suppress("UNREACHABLE_CODE")

package com.example.composeassignment

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeassignment.ui.theme.ComposeAssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeAssignmentTheme {
                MyApp()
            }
        }
    }
}

val customFontFamily = FontFamily(
    Font(R.font.barlow_condensed_light)
)

@Composable
fun MyAppBar() {
    val context = LocalContext.current
    Row(
        modifier = Modifier.padding(
            start = 25.dp,
            top = 41.dp,
            end = 25.dp,
            bottom = 25.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(id = R.drawable.combined_shape),
            contentDescription = "Logo",
            modifier = Modifier.size(85.76.dp, 28.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier.size(33.dp, 33.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.oval),
                    contentDescription = "Favorite",
                    modifier = Modifier.fillMaxSize()
                )

                Image(
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = "Person",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(17.98.dp, 19.dp)
                        .clickable {
                            showToast(context, "Person Clicked")
                        }
                )
            }

            Spacer(modifier = Modifier.width(46.12.dp))

            Image(
                painter = painterResource(id = R.drawable.add),
                contentDescription = "Add",
                modifier = Modifier
                    .size(16.76.dp)
                    .clickable {
                        showToast(context, "Image Clicked") }
            )

            Spacer(modifier = Modifier.width(37.12.dp))

            Image(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "Menu",
                modifier = Modifier
                    .size(17.dp, 13.dp)
                    .clickable {
                        showToast(context, "Image Clicked") }
            )
        }

    }
}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun MyProfile() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(R.drawable.group_10_copy),
                contentDescription = "Upload",
                modifier = Modifier.size(28.dp, 32.40.dp)
            )

            Text(
                "Upload",
                fontSize = 14.sp,
                style = TextStyle(
                    fontFamily = customFontFamily
                )
            )
        }

        Column (
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.user_image_1),
                contentDescription = "User Image",
                modifier = Modifier.size(127.dp, 127.dp)
            )
        }

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.edit),
                contentDescription = "Upload",
                modifier = Modifier.size(28.dp, 32.40.dp)
            )

            Text(
                "Edit",
                fontSize = 14.sp,
                style = TextStyle(
                    fontFamily = customFontFamily
                )
            )
        }
    }
}

@Composable
fun TextUserName(name: String){
    Text(name,
        fontFamily = customFontFamily,
        fontSize = 36.sp,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun Line(){
    HorizontalDivider(
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 20.dp),
        thickness = 1.dp,
        color = Color(0xD8D8D8D8)
    )
}

@Composable
fun Figures(){
    Row (
        modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 9.dp, bottom = 8.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        TextWithFigures("2.3K", "Followers")
        TextWithFigures("50", "Artworks")
        TextWithFigures("21", "Exhibition")
    }
}

@Composable
fun TextWithFigures(numberTitle: String, subtitle: String){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(numberTitle,
            fontFamily = customFontFamily,
            fontSize = 24.sp,
            color = Color.Black
        )

        Text(subtitle,
            fontSize = 14.sp,
            fontFamily = customFontFamily,
            color = Color.Black
        )
    }
}

@Composable
fun ProfileDetails(){
    Row (
        modifier = Modifier.fillMaxWidth().padding(top = 30.dp, start = 35.dp, end = 35.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text("My Dashboard",
            fontSize = 14.sp,
            fontFamily = customFontFamily)
        Image(
            modifier = Modifier.size(66.dp, 30.dp),
            painter = painterResource(R.drawable.custom_switch),
            contentDescription = "Switch"
        )

    }
}

@Composable
fun RowDrawables(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(R.drawable.hear),
            contentDescription = "Heart",
            modifier = Modifier.size(19.dp, 16.dp)
        )

        Spacer(modifier = Modifier.width(2.dp))

        Text("120", fontFamily = customFontFamily, fontSize = 18.sp)

        Spacer(modifier = Modifier.width(13.dp))

        Image(
            painter = painterResource(R.drawable.cursor),
            contentDescription = "Heart",
            modifier = Modifier.size(19.dp, 16.dp)
        )

        Spacer(modifier = Modifier.width(2.dp))

        Text("43K", fontFamily = customFontFamily, fontSize = 18.sp)

        Spacer(modifier = Modifier.width(13.dp))

        Image(
            painter = painterResource(R.drawable.share),
            contentDescription = "Heart",
            modifier = Modifier.size(19.dp, 16.dp)
        )

        Spacer(modifier = Modifier.width(2.dp))

        Text("2.3K", fontFamily = customFontFamily, fontSize = 18.sp)
    }
}


@Composable
fun ColorPalette() {
    Box(
        modifier = Modifier.padding(18.dp).fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.bitmap),
            contentDescription = "Colors",
            modifier = Modifier.size(350.dp, 45.dp)
        )

        Text(
            text = "pallette",
            fontFamily = customFontFamily,
            color = Color.White, fontSize = 14.sp,
            modifier = Modifier.padding(9.2.dp)
        )
    }
}


@Composable
fun MyApp() {
    ComposeAssignmentTheme {
        Scaffold(
            topBar = {
                MyAppBar() },
            content = { padding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                ) {
                    MyProfile()
                    TextUserName("john.doe")
                    ProfileDetails()
                    Line()
                    Figures()
                    Line()
                    RowDrawables()
                    ColorPalette()
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeAssignmentTheme {
        MyApp()
    }
}