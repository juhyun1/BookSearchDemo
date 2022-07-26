package com.booksearch.core.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.booksearch.core.ui.R
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemList(imageLinks: String?, title: String, description: String?, extra: String? = null, onClick: () -> Unit) {
    Timber.d("Test : imageLinks: $imageLinks")
    Card(
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {
                    onClick()
                },
        ) {
            AsyncImage(
                modifier = Modifier.size(80.dp, 100.dp),
                model = imageLinks?.replace("http", "https"),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                error = painterResource(id = R.drawable.placeholder)
            )
            WidthSpacer(width = 10f)
            Column() {
                Text(
                    text = title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.primary
                )
                description?.let {
                    HeightSpacer(height = 5f)
                    Text(
                        text = it,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 3,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                extra?.let {
                    HeightSpacer(height = 5f)
                    Text(
                        text = it,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 3,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }

}