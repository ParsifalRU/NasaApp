package new_mars_photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nasaapp.databinding.MarsPhotoNewBinding
import com.example.nasaapp.ui.adapters.NewMarsPhotoAdapter

class NewMarsPhoto : Fragment() {
    val adapter = NewMarsPhotoAdapter()
    lateinit var binding: MarsPhotoNewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MarsPhotoNewBinding.inflate(inflater, container, false)
        setVerticalRecyclerView()
        return binding.root
    }

fun setVerticalRecyclerView(){
    binding.vertRecyclerView.adapter = adapter
}

    companion object {
        @JvmStatic
        fun newInstance() = NewMarsPhoto()
    }
}