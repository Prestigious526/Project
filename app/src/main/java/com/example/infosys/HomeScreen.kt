import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.style.TextAlign

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // Light background color
            .padding(16.dp)
    ) {
        // Top Section: Account Balance and Income/Expense Summary
        TopSection()

        Spacer(modifier = Modifier.height(24.dp))

        // Spend Frequency Graph Placeholder (can be replaced with actual graph)
        SpendFrequencyGraph()

        Spacer(modifier = Modifier.height(24.dp))

        // Recent Transactions Section
        RecentTransactions()
    }
}

@Composable
fun TopSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Account Balance",
            fontSize = 16.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "$9400", // Example balance
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SummaryCard("Income", "$5000", Color(0xFF4CAF50))
            SummaryCard("Expenses", "$1200", Color(0xFFF44336))
        }
    }
}

@Composable
fun SummaryCard(title: String, amount: String, backgroundColor: Color) {
    Card(shape = CircleShape, backgroundColor = backgroundColor, modifier = Modifier.size(120.dp)) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = title, color = Color.White, fontSize = 14.sp)
            Text(text = amount, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun SpendFrequencyGraph() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(Color(0xFFE0E0E0), shape = MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Spend Frequency Graph", color = Color.Gray)
    }
}

@Composable
fun RecentTransactions() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Recent Transactions",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        TransactionItem("Shopping", "- $120", "10:00 AM")
        TransactionItem("Subscription", "- $80", "3:30 PM")
        TransactionItem("Food", "- $32", "7:30 PM")
    }
}

@Composable
fun TransactionItem(title: String, amount: String, time: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text(text = time, color = Color.Gray, fontSize = 12.sp)
        }

        Text(text = amount, fontWeight = FontWeight.Bold, color = if (amount.contains("-")) Color.Red else Color.Black)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}
