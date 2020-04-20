package com.example.headspaceapplication.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.headspaceapplication.R
import com.example.headspaceapplication.adapter.util.DataBoundListAdapter
import com.example.headspaceapplication.databinding.PicsumItemBinding
import com.example.headspaceapplication.extensions.bind
import com.example.headspaceapplication.model.PicsumResponse

class PicsumAdapter : DataBoundListAdapter<PicsumResponse>(
    diffCallback = object : DiffUtil.ItemCallback<PicsumResponse>() {

        override fun areItemsTheSame(
            oldItem: PicsumResponse,
            newItem: PicsumResponse
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: PicsumResponse,
            newItem: PicsumResponse
        ): Boolean = oldItem == newItem
    }
) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding =
        parent.bind(R.layout.picsum_item)

    override fun bind(binding: ViewDataBinding, item: PicsumResponse) {
        when (binding) {
            is PicsumItemBinding -> binding.picsumResponse = item
        }
        binding.root.tag = item
    }
}