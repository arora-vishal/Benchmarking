package com.ixigo.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ixigo.demo.WorldCupScheduleActivity.Nation.AFGHANISTAN
import com.ixigo.demo.WorldCupScheduleActivity.Nation.AUSTRALIA
import com.ixigo.demo.WorldCupScheduleActivity.Nation.BANGLADESH
import com.ixigo.demo.WorldCupScheduleActivity.Nation.ENGLAND
import com.ixigo.demo.WorldCupScheduleActivity.Nation.INDIA
import com.ixigo.demo.WorldCupScheduleActivity.Nation.NETHERLANDS
import com.ixigo.demo.WorldCupScheduleActivity.Nation.NEW_ZEALAND
import com.ixigo.demo.WorldCupScheduleActivity.Nation.PAKISTAN
import com.ixigo.demo.WorldCupScheduleActivity.Nation.SOUTH_AFRICA
import com.ixigo.demo.WorldCupScheduleActivity.Nation.SRI_LANKA

class WorldCupScheduleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_schedule)

        val scheduleRecyclerView = findViewById<RecyclerView>(R.id.rv_schedule)
        scheduleRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = ScheduleAdapter(getMatches())
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }

    class ScheduleAdapter(
        private val matches: List<MatchSchedule>
    ) : RecyclerView.Adapter<ScheduleAdapter.MatchScheduleViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchScheduleViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.item_match, parent, false)
            return MatchScheduleViewHolder(view)
        }

        override fun getItemCount() = matches.size

        override fun onBindViewHolder(holder: MatchScheduleViewHolder, position: Int) {
            holder.bind(matches[position])
        }

        class MatchScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val firstNationName = get<TextView>(R.id.tv_first_nation_name)
            private val secondNationName = get<TextView>(R.id.tv_second_nation_name)
            private val firstNationFlag = get<ImageView>(R.id.iv_first_nation_flag)
            private val secondNationFlag = get<ImageView>(R.id.iv_second_nation_flag)
            private val matchNumber = get<TextView>(R.id.tv_match_number)
            private val matchDate = get<TextView>(R.id.tv_match_date)
            private val matchTime = get<TextView>(R.id.tv_match_time)

            fun bind(matchSchedule: MatchSchedule) {
                firstNationName.text = matchSchedule.firstNation.nationName
                secondNationName.text = matchSchedule.secondNation.nationName
                matchNumber.text = "ODI ${matchSchedule.matchNumber} of 48"
                matchDate.text = matchSchedule.matchDate
                matchTime.text = "Starts at ${matchSchedule.matchTime}"
                firstNationFlag.setImageResource(matchSchedule.firstNation.flagRes)
                secondNationFlag.setImageResource(matchSchedule.secondNation.flagRes)
            }

            private fun <T : View> get(id: Int): T {
                return itemView.findViewById(id)
            }
        }
    }

    data class MatchSchedule(
        val firstNation: Nation,
        val secondNation: Nation,
        val matchNumber: String,
        val matchTime: String,
        val matchDate: String
    )

    enum class Nation(
        val nationName: String,
        val flagRes: Int
    ) {
        INDIA("India", R.drawable.india),
        PAKISTAN("Pakistan", R.drawable.pakistan),
        AFGHANISTAN("Afghanistan", R.drawable.afghanistan),
        AUSTRALIA("Australia", R.drawable.australia),
        BANGLADESH("Bangladesh", R.drawable.bangladesh),
        NETHERLANDS("Netherlands", R.drawable.netherlands),
        NEW_ZEALAND("New Zealand", R.drawable.new_zealand),
        SOUTH_AFRICA("South Africa", R.drawable.south_africa),
        SRI_LANKA("Sri Lanka", R.drawable.sri_lanka),
        ENGLAND("England", R.drawable.england)
    }

    private fun getMatches() = listOf(
        MatchSchedule(ENGLAND, NEW_ZEALAND, "1", "2:00pm", "Thu, 5 Oct"),
        MatchSchedule(PAKISTAN, NETHERLANDS, "2", "2:00pm", "Fri, 6 Oct"),
        MatchSchedule(BANGLADESH, AFGHANISTAN, "3", "10:30 am", "Sat, 7 Oct"),
        MatchSchedule(SOUTH_AFRICA, SRI_LANKA, "4", "2:00pm", "Sat, 7 Oct"),
        MatchSchedule(INDIA, AUSTRALIA, "5", "2:00pm", "Sun, 8 Oct"),
        MatchSchedule(NEW_ZEALAND, NETHERLANDS, "6", "2:00pm", "9 Oct"),
        MatchSchedule(ENGLAND, BANGLADESH, "7", "10:30am", "10 Oct"),
        MatchSchedule(PAKISTAN, SRI_LANKA, "8", "2:00pm", "10 Oct"),
        MatchSchedule(INDIA, AFGHANISTAN, "9", "2:00pm", "11 Oct"),
        MatchSchedule(AUSTRALIA, SOUTH_AFRICA, "10", "2:00pm", "12 Oct"),
        MatchSchedule(NEW_ZEALAND, BANGLADESH, "11", "2:00pm", "13 Oct"),
        MatchSchedule(INDIA, PAKISTAN, "12", "2:00pm", "14 Oct"),
        MatchSchedule(ENGLAND, AFGHANISTAN, "13", "2:00pm", "15 Oct"),
        MatchSchedule(AUSTRALIA, SRI_LANKA, "14", "2:00pm", "16 Oct"),
        MatchSchedule(SOUTH_AFRICA, NETHERLANDS, "15", "2:00pm", "17 Oct"),
        MatchSchedule(NEW_ZEALAND, AFGHANISTAN, "16", "2:00pm", "18 Oct"),
        MatchSchedule(INDIA, BANGLADESH, "17", "2:00pm", "19 Oct"),
        MatchSchedule(AUSTRALIA, PAKISTAN, "18", "2:00pm", "20 Oct"),
        MatchSchedule(NETHERLANDS, SRI_LANKA, "19", "10:30am", "21 Oct"),
        MatchSchedule(ENGLAND, SOUTH_AFRICA, "20", "2:00pm", "21 Oct"),
        MatchSchedule(INDIA, NEW_ZEALAND, "21", "2:00pm", "22 Oct"),
        MatchSchedule(PAKISTAN, AFGHANISTAN, "22", "2:00pm", "23 Oct"),
        MatchSchedule(SOUTH_AFRICA, BANGLADESH, "23", "2:00pm", "24 Oct"),
        MatchSchedule(AUSTRALIA, NETHERLANDS, "24", "2:00pm", "25 Oct"),
        MatchSchedule(ENGLAND, SRI_LANKA, "25", "2:00pm", "26 Oct"),
        MatchSchedule(PAKISTAN, SOUTH_AFRICA, "26", "2:00pm", "27 Oct"),
        MatchSchedule(AUSTRALIA, NEW_ZEALAND, "27", "10:30am", "28 Oct"),
        MatchSchedule(NETHERLANDS, BANGLADESH, "28", "2:00pm", "28 Oct"),
        MatchSchedule(INDIA, ENGLAND, "29", "2:00pm", "29 Oct"),
        MatchSchedule(AFGHANISTAN, SRI_LANKA, "30", "2:00pm", "30 Oct"),
        MatchSchedule(PAKISTAN, BANGLADESH, "31", "2:00pm", "31 Oct"),
        MatchSchedule(NEW_ZEALAND, SOUTH_AFRICA, "32", "2:00pm", "1 Nov"),
        MatchSchedule(INDIA, SRI_LANKA, "33", "2:00pm", "2 Mov"),
        MatchSchedule(NETHERLANDS, AFGHANISTAN, "34", "2:00pm", "3 Nov"),
        MatchSchedule(NEW_ZEALAND, PAKISTAN, "35", "10:30am", "4 Nov"),
        MatchSchedule(ENGLAND, AUSTRALIA, "36", "2:00pm", "4 Nov"),
        MatchSchedule(INDIA, SOUTH_AFRICA, "37", "2:00pm", "5 Nov"),
        MatchSchedule(BANGLADESH, SRI_LANKA, "38", "2:00pm", "6 Nov"),
        MatchSchedule(AUSTRALIA, AFGHANISTAN, "39", "2:00pm", "7 Nov"),
        MatchSchedule(ENGLAND, NETHERLANDS, "40", "2:00pm", "8 Nov"),
        MatchSchedule(NEW_ZEALAND, SRI_LANKA, "41", "2:00pm", "9 Nov"),
        MatchSchedule(SOUTH_AFRICA, AFGHANISTAN, "42", "2:00pm", "10 Nov"),
        MatchSchedule(AUSTRALIA, BANGLADESH, "43", "10:30am", "11 Nov"),
        MatchSchedule(ENGLAND, PAKISTAN, "44", "2:00pm", "11 Nov"),
        MatchSchedule(INDIA, NETHERLANDS, "45", "2:00pm", "12 Nov")
    )


}