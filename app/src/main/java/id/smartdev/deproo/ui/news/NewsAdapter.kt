package id.smartdev.deproo.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.smartdev.deproo.data.model.Article
import id.smartdev.deproo.databinding.ItemNewsBinding
import id.smartdev.deproo.util.Helper

class NewsAdapter(
    private val listArtcle: List<Article>,
    private val listener: (Article) -> Unit
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listArtcle[position], listener)
    }

    override fun getItemCount(): Int = listArtcle.size

    class ViewHolder(private val holder: ItemNewsBinding) : RecyclerView.ViewHolder(holder.root) {
        fun bind(article: Article, listener: (Article) -> Unit) {
            holder.tvTitle.text = article.title
            holder.tvAuthor.text = article.author
            holder.tvSource.text = article.source?.name
            holder.tvDescription.text = article.description
            holder.tvTime.text = article.publishedAt

            Glide.with(itemView.context)
                .load(article.urlToImage)
                .apply(Helper.requestOperation)
                .into(holder.ivNews)

            itemView.setOnClickListener {
                listener(article)
            }
        }
    }

}