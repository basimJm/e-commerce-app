import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce_task.databinding.RowOrderMainImageBinding
import com.task.ecommerce.model.itemsinfo.Image

class OrderImageAdapter(private val items: List<Image>?) : RecyclerView.Adapter<OrderImageAdapter.OrderImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderImageViewHolder {
        val binding = RowOrderMainImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderImageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onBindViewHolder(holder: OrderImageViewHolder, position: Int) {
        val image = items?.get(position)
        holder.bind(image)
    }

    inner class OrderImageViewHolder(private val binding: RowOrderMainImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(image: Image?) {
            binding.data = image
        }
    }
}