let selectedFilters = {
    function: [],
    experience: [],
    job: [],
    location: []
};

function toggleFilterOptions(filterType) {
    const filterElement = document.getElementById(filterType + 'Filter');
    if (filterElement) {
        const isCurrentlyVisible = filterElement.style.display === 'block';
        
        // 모든 필터 옵션을 닫습니다.
        document.querySelectorAll('.filter-options').forEach(el => {
            el.style.display = 'none';
        });
        
        // 모든 버튼에서 'active' 클래스를 제거합니다.
        document.querySelectorAll('.filter-buttons button').forEach(btn => {
            btn.classList.remove('active');
        });

        // 현재 필터가 보이지 않았다면 보이게 하고, 보였다면 숨깁니다.
        if (!isCurrentlyVisible) {
            filterElement.style.display = 'block';
            event.target.classList.add('active');
        }
    }
}

function toggleFilter(filterType, value, button) {
    const index = selectedFilters[filterType].indexOf(value);
    
    if (index > -1) {
        selectedFilters[filterType].splice(index, 1);
        button.classList.remove('btn-success');
        button.classList.add('btn-outline-secondary');
    } else {
        selectedFilters[filterType].push(value);
        button.classList.remove('btn-outline-secondary');
        button.classList.add('btn-success');
    }
    
    applyFilters();
}

function applyFilters() {
    const filteredPostings = jobPostings.filter(posting => {
        return (selectedFilters.function.length === 0 || selectedFilters.function.includes(posting.function)) &&
               (selectedFilters.experience.length === 0 || selectedFilters.experience.includes(posting.experience)) &&
               (selectedFilters.job.length === 0 || selectedFilters.job.includes(posting.job)) &&
               (selectedFilters.location.length === 0 || selectedFilters.location.includes(posting.location));
    });

    displayJobPostings(filteredPostings);
}

function displayJobPostings(postings) {
    const container = document.getElementById('jobPostings');
    container.innerHTML = '';
    
    if (postings.length === 0) {
        container.innerHTML = '<p>해당하는 채용 공고가 없습니다.</p>';
        return;
    }
    
    postings.forEach(posting => {
        const postingElement = document.createElement('div');
        postingElement.className = 'col';
        const imageUrl = posting.jobPostId ? `/resources/image/${posting.jobPostId}.png` : '/resources/image/default.png';
        postingElement.innerHTML = `
            <div class="card shadow-sm" style="cursor: pointer;">
                <div class="card-header d-flex justify-content-end">
                    <button class="btn btn-sm btn-outline-primary me-2 edit-btn">수정</button>
                    <button class="btn btn-sm btn-outline-danger delete-btn">삭제</button>
                </div>
                <img src="${imageUrl}" class="card-img-top" alt="${posting.title}" style="height: 225px; object-fit: cover;">
                <div class="card-body">
                    <h5 class="card-title">${posting.title}</h5>
                    <p class="card-text"><strong>경력:</strong> ${posting.experience}</p>
                    <p class="card-text"><strong>마감일:</strong> ${posting.endDate}</p>
                    <p class="card-text"><strong>내용:</strong> ${posting.content}</p>
                </div>
            </div>
        `;
        
        const card = postingElement.querySelector('.card');
        const editBtn = postingElement.querySelector('.edit-btn');
        const deleteBtn = postingElement.querySelector('.delete-btn');
        
        if (editBtn && deleteBtn) {
            editBtn.addEventListener('click', function(e) {
                e.stopPropagation();
                console.log('Edit button clicked for job post ID:', posting.jobPostId);
                // editJobPosting(posting.jobPostId);
            });
            
            deleteBtn.addEventListener('click', function(e) {
                e.stopPropagation();
                console.log('Delete button clicked for job post ID:', posting.jobPostId);
                // deleteJobPosting(posting.jobPostId);
            });
        } else {
            console.error('Edit or Delete button not found for job post ID:', posting.jobPostId);
        }
        
        card.addEventListener('click', function(e) {
            if (!e.target.classList.contains('btn')) {
                openJobDetails(posting.jobPostId);
            }
        });
        
        // 호버 효과 추가
        card.addEventListener('mouseenter', function() {
            this.classList.add('hover-effect');
        });

        card.addEventListener('mouseleave', function() {
            this.classList.remove('hover-effect');
        }); 
        
        container.appendChild(postingElement);
    });
}

function openJobDetails(jobPostId) {
    const url = `/jobPost/detail/${jobPostId}`;
    window.open(url, '_blank', 'width=800,height=600');
}

document.addEventListener('DOMContentLoaded', function() {
    applyFilters();

    const filterButtons = document.querySelectorAll('.filter-buttons button');
    filterButtons.forEach(button => {
        button.addEventListener('click', function(event) {
            const filterType = this.textContent.replace('별', '');
            toggleFilterOptions(filterType);
        });
    });

    const filterOptionButtons = document.querySelectorAll('.filter-options button');
    filterOptionButtons.forEach(button => {
        button.addEventListener('click', function(event) {
            const filterType = this.closest('.filter-options').id.replace('Filter', '');
            const value = this.textContent.trim();
            toggleFilter(filterType, value, this);
        });
    });
});