package com.example.lab4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class ParticipantAdapter(
    private val participants: MutableList<Participant>,
    private val onDeleteClick: (Participant) -> Unit
) : RecyclerView.Adapter<ParticipantAdapter.ParticipantViewHolder>() {

    inner class ParticipantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val participantName: TextView = itemView.findViewById(R.id.participantName)
        private val deleteButton: ImageButton = itemView.findViewById(R.id.deleteButton)

        fun bind(participant: Participant) {
        //TODO 4: implement the bind method
            participantName.text = participant.name
            deleteButton.setOnClickListener {
                onDeleteClick(participant)
            }

        }
    }

    //TODO 5: override the methods
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParticipantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_participant, parent, false)
        return ParticipantViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParticipantViewHolder, position: Int) {
        holder.bind(participants[position])
    }

    override fun getItemCount(): Int = participants.size

    fun updateParticipants(newParticipants: List<Participant>) {
    // TODO 8: Clear the list and add all the new participants
        participants.clear()
        participants.addAll(newParticipants)
        notifyDataSetChanged()
    }
}
