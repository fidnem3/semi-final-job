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
        console.log('Full posting object:', posting);
        const postingElement = document.createElement('div');
        postingElement.className = 'col';
        const imageUrl = posting.fileName && posting.filePath ? `/uploads/${posting.fileName}` : '/resources/image/10.png';
        console.log('imageUrl:', imageUrl);
         
        postingElement.innerHTML = `
            <div class="card shadow-sm job-posting" style="cursor: pointer; transition: all 0.3s ease; box-shadow: 0 2px 5px rgba(0,0,0,0.1); border-radius: 10px; overflow: hidden;">
                <img src="${imageUrl}" class="card-img-top" alt="${posting.title}" 
                     style="height: 200px; object-fit: cover;"
                     onerror="this.onerror=null; this.src='/resources/image/10.png'; console.error('Image load failed:', this.src);">
                <div class="card-body" style="padding: 20px; background-color: #ffffff;">
                    <h5 class="card-title" style="font-size: 1.3rem; font-weight: 600; color: #2c3e50; margin-bottom: 15px; border-bottom: 2px solid #3498db; padding-bottom: 10px;">${posting.title}</h5>
                    <div style="display: grid; grid-template-columns: auto 1fr; gap: 10px; font-size: 0.95rem; color: #34495e;">
                        <span style="font-weight: 600; color: #3498db;">경력:</span>
                        <span>${posting.experience}</span>
                        <span style="font-weight: 600; color: #3498db;">직업:</span>
                        <span>${posting.job}</span>
                        <span style="font-weight: 600; color: #3498db;">지역:</span>
                        <span>${posting.location}</span>
                        <span style="font-weight: 600; color: #3498db;">기능:</span>
                        <span>${posting.function}</span>
                    </div>
                </div>
            </div>
        `;
        
        const card = postingElement.querySelector('.card');
        
        card.addEventListener('click', function(e) {
            openJobDetails(posting.jobPostId);
        });
        
        // 호버 효과 추가
        card.addEventListener('mouseenter', function() {
            this.classList.add('hover-effect');
            this.style.transform = 'translateY(-5px)';
            this.style.boxShadow = '0 8px 15px rgba(0,0,0,0.1)';
        });

        card.addEventListener('mouseleave', function() {
            this.classList.remove('hover-effect');
            this.style.transform = 'translateY(0)';
            this.style.boxShadow = '0 2px 5px rgba(0,0,0,0.1)';
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