
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.R
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.details_employee
import com.example.android.marsphotos.network.Employee


class PhotoGridAdapter : ListAdapter<Employee,
        PhotoGridAdapter.MarsPhotoViewHolder>(DiffCallback) {
    companion object DiffCallback : DiffUtil.ItemCallback<Employee>() {
        override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem == newItem
        }
    }
    class MarsPhotoViewHolder(private var binding:
                              GridViewItemBinding
    ):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(EmployeePhoto: Employee) {
            binding.photo = EmployeePhoto
            binding.executePendingBindings()

            // Set the background of the ImageView to a circle shape
            binding.avatar.background = ContextCompat.getDrawable(binding.root.context, R.drawable.circle_background)
        }


        init {
            itemView.setOnClickListener {
                val employee = binding.photo
                val intent = Intent(itemView.context, details_employee::class.java).apply {
                    putExtra("id", employee?.id)
                    putExtra("category", employee?.category)
                    putExtra("country", employee?.country)
                    putExtra("name", employee?.fullname)
                    putExtra("shirt_name", employee?.shirt_name)
                    putExtra("shirt_number", employee?.shirt_number)
                    putExtra("birth_date", employee?.birth_date)
                    putExtra("nationality", employee?.nationality)
                    putExtra("start_date", employee?.start_date)
                    putExtra("avatar", employee?.avatar)
                    putExtra("image", employee?.image)
                    // add more extras as needed
                }
                itemView.context.startActivity(intent)
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoGridAdapter.MarsPhotoViewHolder {
        return MarsPhotoViewHolder(GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhotoGridAdapter.MarsPhotoViewHolder, position: Int) {
        val employeePhoto = getItem(position)
        holder.bind(employeePhoto)


    }
}